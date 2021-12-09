package by.tc.task04.command;

public final class PagePath {
    public static final String ERROR_404_PAGE = "WEB-INF/jsp/error-404.jsp";
    public static final String ERROR_404_PAGE_REDIRECT = "/controller?command=error-404";
    public static final String ERROR_500_PAGE = "WEB-INF/jsp/error-500.jsp";
    public static final String ERROR_500_PAGE_REDIRECT = "/controller?command=error-500";

    public static final String REGISTER_PAGE = "WEB-INF/jsp/register.jsp";
    public static final String REGISTER_PAGE_REDIRECT = "/controller?command=show-register";

    public static final String HOME_PAGE = "WEB-INF/jsp/home.jsp";
    public static final String HOME_PAGE_REDIRECT = "/controller?command=home";

    public static final String LOGIN_PAGE = "WEB-INF/jsp/login.jsp";
    public static final String LOGIN_PAGE_REDIRECT = "/controller?command=show-login";

    public static final String HOTEL_ROOM_PAGE = "WEB-INF/jsp/hotelRoom.jsp";

    public static final String BOOK_PAGE = "WEB-INF/jsp/booking.jsp";
    public static final String BOOK_PAGE_REDIRECT = "/controller?command=show-booking";

    public static final String MY_BOOKINGS_PAGE = "WEB-INF/jsp/myBookings.jsp";
    public static final String ALL_BOOKINGS_PAGE = "WEB-INF/jsp/allBookings.jsp";
}
