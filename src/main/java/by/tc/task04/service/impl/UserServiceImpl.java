package by.tc.task04.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import by.tc.task04.dao.DAOFactory;
import by.tc.task04.dao.UserDAO;
import by.tc.task04.dao.impl.UserDAOImpl;
import by.tc.task04.entity.User;
import by.tc.task04.exceptions.DAOException;
import by.tc.task04.exceptions.ServiceException;
import by.tc.task04.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

import static at.favre.lib.crypto.bcrypt.BCrypt.MIN_COST;

public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();

    private final UserDAO userDao = UserDAOImpl.getInstance();

    private final BCrypt.Hasher hasher;
    private final BCrypt.Verifyer verifier;

    public UserServiceImpl() {
        hasher = BCrypt.withDefaults();
        verifier = BCrypt.verifyer();
    }


    @Override
    public boolean register(String login, String password, String firstName, String lastName) throws ServiceException {
        User user = new User(login, password, 2, firstName, lastName);
        final String encryptPassword = hasher.hashToString(MIN_COST, user.getPasswordHash().toCharArray());
        user.setPasswordHash(encryptPassword);

        try {
            if (!userDao.findUserByLogin(login).isPresent()) {
                userDao.save(user);
                return true;
            } else {
                throw new ServiceException("User with such login is exist!");
            }
        } catch (DAOException e) {
            logger.error("Unable to save new user to Data Source. {}", e.getMessage());
            throw new ServiceException("Unable to save new user to Data Source.", e);
        }
    }

    @Override
    public boolean canLogIn(User user) {
        try {
            User fundedUser = this.findByLogin(user.getLogin());
            return verifier.verify(user.getPasswordHash().getBytes(),
                    fundedUser.getPasswordHash().getBytes()).verified;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User findByLogin(String login) throws ServiceException {
        return userDao.findUserByLogin(login).orElseThrow(() -> new ServiceException("User with such id is not exist!"));
    }
}
