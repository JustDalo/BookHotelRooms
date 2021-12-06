package by.tc.task04.command.impl;

import by.tc.task04.command.Command;
import by.tc.task04.command.PagePath;
import by.tc.task04.command.Routing;
import by.tc.task04.command.RoutingType;
import by.tc.task04.entity.User;
import by.tc.task04.exceptions.ServiceException;
import by.tc.task04.service.ServiceFactory;
import by.tc.task04.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class RegisterCommand implements Command {

    private static final String PASSWORD_PARAMETER = "password";
    private static final String LOGIN_PARAMETER = "login";
    private static final String FIRST_NAME = "first-name";
    private static final String LAST_NAME = "last-name";
    private static final Object LOGIN_IS_EXIST_MSG = "This login is already exist!!";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String NOT_ENOUGH_DATA_MSG = "Not enough data!";

    private static final Logger logger = LogManager.getLogger();

    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        Optional<String> firstName = Optional.ofNullable(request.getParameter(FIRST_NAME));
        Optional<String> lastName = Optional.ofNullable(request.getParameter(LAST_NAME));
        Optional<String> login = Optional.ofNullable(request.getParameter(LOGIN_PARAMETER));
        Optional<String> password = Optional.ofNullable(request.getParameter(PASSWORD_PARAMETER));

        UserService userService = ServiceFactory.getInstance().getUserService();
        boolean isRegistered;
        try {
            isRegistered = userService.register(
                    login.orElse(null),
                    password.orElse(null),
                    firstName.orElse(null),
                    lastName.orElse(null)
            );
        } catch (ServiceException e) {
            logger.error("Unable to register new user. {}", e.getMessage());
            return Routing.ERROR_500;
        }
        if (isRegistered) {
            return new Routing(PagePath.HOME_PAGE_REDIRECT, RoutingType.REDIRECT);
        } else {
            request.getSession().setAttribute(ERROR_ATTRIBUTE, LOGIN_IS_EXIST_MSG);
            return new Routing(PagePath.REGISTER_PAGE_REDIRECT, RoutingType.REDIRECT);
        }

    }
}
