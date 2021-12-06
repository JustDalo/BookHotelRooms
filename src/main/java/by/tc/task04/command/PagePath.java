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
}
