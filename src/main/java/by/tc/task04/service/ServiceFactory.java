package by.tc.task04.service;

import by.tc.task04.entity.HotelRoom;
import by.tc.task04.service.impl.HotelRoomServiceImpl;
import by.tc.task04.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

public class ServiceFactory {
    private final UserService userService = new UserServiceImpl();
    private final HotelRoomService hotelRoomService = new HotelRoomServiceImpl();

    private ServiceFactory() {}

    public UserService getUserService() {
        return userService;
    }
    public HotelRoomService getHotelRoomService() {return hotelRoomService; }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
