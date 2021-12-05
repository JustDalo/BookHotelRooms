package by.tc.task04.service.impl;

import by.tc.task04.dao.DAOFactory;
import by.tc.task04.dao.UserDAO;
import by.tc.task04.entity.User;
import by.tc.task04.exceptions.DAOException;
import by.tc.task04.exceptions.ServiceException;
import by.tc.task04.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public User login(String login, String password) throws ServiceException {
        if (login == null || password == null) {
            return null;
        }

        User user = null;

        return user;
    }

    @Override
    public boolean register(String login, String password, String firstName, String lastName) throws ServiceException {
        User user = new User(1, login, password, 2, firstName, lastName);

        UserDAO userDao = DAOFactory.getInstance().getUserDAO();
        try {
            userDao.save(user);
        } catch (DAOException e) {
            logger.error("Unable to save new user to Data Source. {}", e.getMessage());
            throw new ServiceException("Unable to save new user to Data Source.", e);
        }
        return true;

    }
}
