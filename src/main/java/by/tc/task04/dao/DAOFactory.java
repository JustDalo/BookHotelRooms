package by.tc.task04.dao;

import by.tc.task04.dao.impl.UserDAOImpl;

public class DAOFactory {

    private final UserDAO userDAO = new UserDAOImpl();

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final DAOFactory INSTANCE = new DAOFactory();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
