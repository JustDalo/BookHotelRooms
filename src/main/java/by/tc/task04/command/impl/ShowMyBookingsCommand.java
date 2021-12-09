package by.tc.task04.command.impl;

import by.tc.task04.command.Command;
import by.tc.task04.command.PagePath;
import by.tc.task04.command.Routing;
import by.tc.task04.command.RoutingType;
import by.tc.task04.entity.User;
import by.tc.task04.exceptions.ServiceException;
import by.tc.task04.service.BookingService;
import by.tc.task04.service.ServiceFactory;
import by.tc.task04.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowMyBookingsCommand implements Command {
    private static final String BOOKS_ATTRIBUTE = "books";
    private static final String USER_SESSION_ATTRIBUTE = "user";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final Object ERROR_USER_IS_NULL = "Login or Sign in to see your bookings !";

    private final BookingService bookService = ServiceFactory.getInstance().getBookingService();
    private final UserService userService = ServiceFactory.getInstance().getUserService();


    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        final HttpSession session = request.getSession(true);
        User user;
        if (session.getAttribute(USER_SESSION_ATTRIBUTE) == null) {
            request.setAttribute(ERROR_ATTRIBUTE, ERROR_USER_IS_NULL);
            return new Routing(PagePath.BOOK_PAGE, RoutingType.FORWARD);
        } else {
            String userLogin = String.valueOf(session.getAttribute(USER_SESSION_ATTRIBUTE));
            try {
                user = userService.findByLogin(userLogin);
            } catch (ServiceException e) {
                request.setAttribute(BOOKS_ATTRIBUTE, e.getMessage());
                return new Routing(PagePath.MY_BOOKINGS_PAGE, RoutingType.FORWARD);
            }
        }
        request.setAttribute(BOOKS_ATTRIBUTE, bookService.findByUser(user.getId()));
        return new Routing(PagePath.MY_BOOKINGS_PAGE, RoutingType.FORWARD);
    }
}
