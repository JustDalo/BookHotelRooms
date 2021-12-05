package by.tc.task04.command;

public class Routing {
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
