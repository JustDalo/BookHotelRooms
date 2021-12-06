package by.tc.task04.command;

public class Routing {
    public static final Routing ERROR_404 = new Routing(PagePath.ERROR_404_PAGE_REDIRECT, RoutingType.REDIRECT);
    public static final Routing ERROR_500 = new Routing(PagePath.ERROR_500_PAGE_REDIRECT, RoutingType.REDIRECT);

    private final String resource;
    private final RoutingType type;


    public Routing(String resource, RoutingType resultType) {
        this.resource = resource;
        type = resultType;
    }

    public String getResource() {
        return resource;
    }

    public RoutingType getRoutingType() {
        return type;
    }
}
