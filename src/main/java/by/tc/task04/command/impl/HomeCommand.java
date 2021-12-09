package by.tc.task04.command.impl;

import by.tc.task04.command.Command;
import by.tc.task04.command.PagePath;
import by.tc.task04.command.Routing;
import by.tc.task04.command.RoutingType;
import by.tc.task04.service.HotelRoomService;
import by.tc.task04.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeCommand implements Command {
    private static final String ROOMS_ATTRIBUTE = "rooms";

    private final HotelRoomService roomService = ServiceFactory.getInstance().getHotelRoomService();
    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(ROOMS_ATTRIBUTE, roomService.findAll());
        return new Routing(PagePath.HOME_PAGE, RoutingType.FORWARD);
    }
}
