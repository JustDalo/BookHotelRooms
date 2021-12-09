package by.tc.task04.command.impl;

import by.tc.task04.command.Command;
import by.tc.task04.command.PagePath;
import by.tc.task04.command.Routing;
import by.tc.task04.command.RoutingType;
import by.tc.task04.service.BookingService;
import by.tc.task04.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowAllBookingsCommand implements Command {
    private static final String BOOKS_ATTRIBUTE = "books";

    private final BookingService bookService = ServiceFactory.getInstance().getBookingService();


    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(BOOKS_ATTRIBUTE, bookService.findAll());
        return new Routing(PagePath.ALL_BOOKINGS_PAGE, RoutingType.FORWARD);
    }
}
