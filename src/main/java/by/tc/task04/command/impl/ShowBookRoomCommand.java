package by.tc.task04.command.impl;

import by.tc.task04.command.Command;
import by.tc.task04.command.PagePath;
import by.tc.task04.command.Routing;
import by.tc.task04.command.RoutingType;
import by.tc.task04.service.HotelRoomService;
import by.tc.task04.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBookRoomCommand implements Command {
    private static final String ROOM_ATTRIBUTE = "room";
    private static final String ID_PARAMETER = "id";
    private final HotelRoomService roomService = ServiceFactory.getInstance().getHotelRoomService();

    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter(ID_PARAMETER));
        request.setAttribute(ROOM_ATTRIBUTE, roomService.findById(id).get());
        return new Routing(PagePath.BOOK_PAGE, RoutingType.FORWARD);
    }
}
