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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookRoomCommand implements Command {
    private static final String BOOK_ATTRIBUTE = "book";
    private static final String USER_SESSION_ATTRIBUTE = "user";
    private static final String ROOM_ID_ATTRIBUTE = "id";
    private static final String START_DATE_PARAMETER = "startDay";
    private static final String LAST_DATE_PARAMETER = "lastDay";
    private static final String ADULTS_COUNT_PARAMETER = "adultsCount";
    private static final String CHILDREN_COUNT_PARAMETER = "childrenCount";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String CAN_NOT_BOOK_NOT_USER = "Login or Sign in to book this room";
    private static final String CAN_NOT_BOOK_INVALID_DATE = "Invalid Date!";


    private final BookingService bookService = ServiceFactory.getInstance().getBookingService();
    private final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        final HttpSession session = request.getSession(true);
        User user;
        if (session.getAttribute(USER_SESSION_ATTRIBUTE) == null) {
            request.setAttribute(ERROR_ATTRIBUTE, CAN_NOT_BOOK_NOT_USER);
            return new Routing(PagePath.BOOK_PAGE, RoutingType.FORWARD);
        } else {
            String userLogin = String.valueOf(session.getAttribute(USER_SESSION_ATTRIBUTE));
            try {
                user = userService.findByLogin(userLogin);
            } catch (ServiceException e) {
                request.setAttribute(ERROR_ATTRIBUTE, e.getMessage());
                return new Routing(PagePath.BOOK_PAGE, RoutingType.FORWARD);
            }
        }
        long roomId = Long.parseLong(request.getParameter(ROOM_ID_ATTRIBUTE));

        Date startDate;
        Date lastDate;
        try {
            startDate = new SimpleDateFormat(DATE_PATTERN).parse(request.getParameter(START_DATE_PARAMETER));
            lastDate = new SimpleDateFormat(DATE_PATTERN).parse(request.getParameter(LAST_DATE_PARAMETER));

        } catch (ParseException e) {
            request.setAttribute(ERROR_ATTRIBUTE, CAN_NOT_BOOK_INVALID_DATE);
            return new Routing(PagePath.BOOK_PAGE, RoutingType.FORWARD);
        }

        int adultsCount = Integer.parseInt(request.getParameter(ADULTS_COUNT_PARAMETER));
        int childrenCount = Integer.parseInt(request.getParameter(CHILDREN_COUNT_PARAMETER));

        try {
            request.setAttribute(BOOK_ATTRIBUTE, bookService.bookRoom(user.getId(), roomId, startDate, lastDate, adultsCount, childrenCount));
        } catch (ServiceException e) {
            request.setAttribute(ERROR_ATTRIBUTE, e.getMessage());
            return new Routing(PagePath.BOOK_PAGE, RoutingType.FORWARD);
        }
        return new Routing(PagePath.HOME_PAGE, RoutingType.FORWARD);
    }
}
