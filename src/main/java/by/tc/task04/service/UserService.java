package by.tc.task04.service;

import by.tc.task04.dao.DAO;
import by.tc.task04.dao.UserDAO;
import by.tc.task04.dao.impl.UserDAOImpl;
import by.tc.task04.entity.User;
import by.tc.task04.exceptions.ServiceException;

import java.util.List;

public interface UserService {
    User login(String login, String password) throws ServiceException;

    boolean register(String login, String password, String fistName, String lastName) throws ServiceException;
}
