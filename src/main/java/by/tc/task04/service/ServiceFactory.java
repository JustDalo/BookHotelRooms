package by.tc.task04.service;

import by.tc.task04.service.impl.BookingServiceImpl;
import by.tc.task04.service.impl.HotelRoomServiceImpl;
import by.tc.task04.service.impl.UserServiceImpl;


public class ServiceFactory {
    private final UserService userService = new UserServiceImpl();
    private final HotelRoomService hotelRoomService = new HotelRoomServiceImpl();
    private final BookingService bookingService = new BookingServiceImpl();

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }

    public HotelRoomService getHotelRoomService() {
        return hotelRoomService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
