package by.tc.task04.command.impl;

import by.tc.task04.command.Command;
import by.tc.task04.command.PagePath;
import by.tc.task04.command.Routing;
import by.tc.task04.command.RoutingType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowError500PageCommand implements Command {
    private static final int RESPONSE_STATUS = 500;

    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(RESPONSE_STATUS);
        return new Routing(PagePath.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}
