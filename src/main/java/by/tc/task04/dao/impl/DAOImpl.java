package by.tc.task04.dao.impl;

import by.tc.task04.dao.DAO;
import by.tc.task04.dao.SqlThrowingConsumer;
import by.tc.task04.entity.Database;
import by.tc.task04.exceptions.DAOException;
import by.tc.task04.pool.ConnectionPoolImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class DAOImpl<T extends Database> implements DAO<T> {

    static final Logger LOGGER = LogManager.getRootLogger();

    private static final String FIND_ALL_SQL_TEMPLATE = "select * from %s";
    protected static final String FIND_BY_PARAM_SQL_TEMPLATE = "select * from %s where %s = ?";
    private static final String SAVE_SQL_TEMPLATE = "INSERT INTO %s (%s) VALUES ";
    private static final String DELETE_SQL_TEMPLATE = "DELETE FROM %s WHERE id = ?";

    private static final String ENTITY_WAS_NOT_SAVED = "The entity was not saved.";
    private static final String ENTITY_WAS_NOT_DELETED = "The entity was not deleted.";
    private static final String ENTITIES_WAS_NOT_FOUND = "Entities were not found.";

    protected final ConnectionPoolImpl pool = ConnectionPoolImpl.getInstance();
    protected final String tableName;
    private final String findAllSql;
    private final String findByIdSql;
    private final String insertSql;
    private final String deleteSql;

    public DAOImpl(String tableName) {
        this.tableName = tableName;
        this.findAllSql = String.format(FIND_ALL_SQL_TEMPLATE, tableName);
        this.findByIdSql = String.format(FIND_BY_PARAM_SQL_TEMPLATE, tableName, "id");
        this.insertSql = String.format(SAVE_SQL_TEMPLATE, tableName, getFieldsNames());
        this.deleteSql = String.format(DELETE_SQL_TEMPLATE, tableName);
    }

    @Override
    public T save(T entity) {
        try {
            final Connection connection = pool.takeConnection();
            Statement statement = connection.createStatement();
            String sql = insertSql + getValuesForSaving(entity);
            statement.executeUpdate(sql);
            statement.close();
            pool.releaseConnection(connection);
        } catch (SQLException e) {
            LOGGER.error(ENTITY_WAS_NOT_SAVED + e.getMessage());
        }
        return entity;
    }

    @Override
    public List findAll() {
        return findEntities(findAllSql);
    }

    @Override
    public Optional findById(Long id) {
        return takeFirstNotNull(
                findPreparedEntities(whereId(id), findByIdSql));
    }

    private static SqlThrowingConsumer<PreparedStatement> whereId(long id) {
        return statement -> statement.setLong(1, id);
    }

    @Override
    public void delete(Long id) {
        try {
            final Connection connection = pool.takeConnection();
            PreparedStatement statement = connection.prepareStatement(deleteSql);
            statement.setLong(1, id);
            statement.execute();
            statement.close();
            pool.releaseConnection(connection);
        } catch (SQLException e) {
            LOGGER.error(ENTITY_WAS_NOT_DELETED + e.getMessage());
        }
    }

    protected Optional<T> takeFirstNotNull(List<T> entities) {
        return entities.stream()
                .filter(Objects::nonNull)
                .findFirst();
    }

    protected List<T> findPreparedEntities(SqlThrowingConsumer<PreparedStatement> consumer, String sql) {
        List<T> entities = new ArrayList<>();
        try {
            final Connection connection = pool.takeConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            consumer.accept(statement);
            try (final ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    final T entity = mapResultSet(resultSet);
                    entities.add(entity);
                }
            }
            statement.close();
            pool.releaseConnection(connection);
        } catch (SQLException e) {
            LOGGER.error(ENTITIES_WAS_NOT_FOUND + e.getMessage());
        }
        return entities;
    }


    protected List<T> findEntities(String sql) {
        List<T> entities = new ArrayList<>();
        try {
            final Connection connection = pool.takeConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                final T entity = mapResultSet(resultSet);
                entities.add(entity);
            }
            statement.close();
            pool.releaseConnection(connection);
        } catch (SQLException e) {
            LOGGER.error(ENTITIES_WAS_NOT_FOUND + e.getMessage());
        }
        return entities;
    }



    protected abstract String getValuesForSaving(T entity);

    protected abstract String getFieldsNames();

    protected abstract T mapResultSet(ResultSet resultSet) throws SQLException;
}
