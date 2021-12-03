package by.tc.task04.dao.impl;

import by.tc.task04.dao.UserDAO;
import by.tc.task04.entity.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class UserDAOImpl extends DAOImpl<User> implements UserDAO {
    private static final String USER_TABLE_NAME = "user";
    private static final String USER_ID = "id";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";

    private static UserDAOImpl instance;

    public UserDAOImpl() {
        super(USER_TABLE_NAME);
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
    public Optional<User> findUserByName(String name) {
        return Optional.empty();
    }

    @Override
    protected void prepareForUpdate(PreparedStatement statement, User entity) throws SQLException {

    }

    @Override
    protected String getValuesForSaving(User entity) {
        return null;
    }

    @Override
    protected String getFieldsNames() {
        return null;
    }

    @Override
    protected String getFieldsNamesForUpdate() {
        return null;
    }
}
