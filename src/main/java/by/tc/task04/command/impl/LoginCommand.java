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

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String PASSWORD_PARAM = "password";
    private static final String LOGIN_PARAM = "login";
    private static final String USER_SESSION_ATTRIBUTE = "user";
    private static final String USER_ROLE_SESSION_ATTRIBUTE = "role";
    private static final String CAN_NOT_LOGIN_MSG = "Wrong login or password!";
    private static final String ERROR_ATTRIBUTE = "error";


    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        String password = request.getParameter(PASSWORD_PARAM);
        String login = request.getParameter(LOGIN_PARAM);

        User logUser = new User(login, password);
        if (userService.canLogIn(logUser)) {
            Optional.ofNullable(request.getSession(false)).ifPresent(HttpSession::invalidate);
            final HttpSession session = request.getSession(true);
            session.setAttribute(USER_SESSION_ATTRIBUTE, login);
            try {
                session.setAttribute(USER_ROLE_SESSION_ATTRIBUTE, (Integer) userService.findByLogin(login).getRoleId());
            } catch (ServiceException e) {
                request.setAttribute(ERROR_ATTRIBUTE, e.getMessage());
                return new Routing(PagePath.LOGIN_PAGE, RoutingType.FORWARD);
            }
            return new Routing(PagePath.HOME_PAGE_REDIRECT, RoutingType.REDIRECT);

        } else {
            request.setAttribute(ERROR_ATTRIBUTE, CAN_NOT_LOGIN_MSG);
            return new Routing(PagePath.LOGIN_PAGE, RoutingType.FORWARD);

        }

    }
}
