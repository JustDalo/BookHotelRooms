package by.tc.task04.dao.impl;

import by.tc.task04.dao.SqlThrowingConsumer;
import by.tc.task04.dao.UserDAO;
import by.tc.task04.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAOImpl extends DAOImpl<User> implements UserDAO {
    private static final String USER_TABLE_NAME = "user_info";
    private static final String USER_ID = "id";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";
    private static final String USER_ROLE_ID = "roleId";
    private static final String USER_FIRST_NAME = "first_name";
    private static final String USER_LAST_NAME = "last_name";

    private final String findByNameSql;

    private static UserDAOImpl instance;

    public UserDAOImpl() {
        super(USER_TABLE_NAME);
        this.findByNameSql = String.format(FIND_BY_PARAM_SQL_TEMPLATE, USER_TABLE_NAME, USER_LOGIN);
    }

    public static UserDAOImpl getInstance() {
        UserDAOImpl localInstance = instance;
        if (localInstance == null) {
            synchronized (UserDAOImpl.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new UserDAOImpl();
                    instance = localInstance;
                }
            }
        }
        return localInstance;
    }

    @Override
    public Optional<User> findUserByLogin(String name) {
        return takeFirstNotNull(
                findPreparedEntities(whereName(name), findByNameSql));
    }

    private static SqlThrowingConsumer<PreparedStatement> whereName(String name) {
        return statement -> statement.setString(1, name);
    }

    @Override
    protected String getValuesForSaving(User entity) {
        return String.format("('%s', '%s', %d, '%s', '%s')",
                entity.getLogin(),
                entity.getPasswordHash(),
                entity.getRoleId(),
                entity.getFirstName(),
                entity.getLastName());
    }

    @Override
    protected String getFieldsNames() {
        return String.format("%s, %s, %s, %s, %s",
                USER_LOGIN, USER_PASSWORD, USER_ROLE_ID, USER_FIRST_NAME, USER_LAST_NAME);
    }

    @Override
    protected User mapResultSet(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getLong(USER_ID),
                resultSet.getString(USER_LOGIN),
                resultSet.getString(USER_PASSWORD),
                resultSet.getInt(USER_ROLE_ID),
                resultSet.getString(USER_FIRST_NAME),
                resultSet.getString(USER_LAST_NAME));
    }
}
