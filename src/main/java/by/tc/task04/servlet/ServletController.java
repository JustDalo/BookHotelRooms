package by.tc.task04.servlet;

import by.tc.task04.command.Command;
import by.tc.task04.command.CommandFactory;
import by.tc.task04.command.PagePath;
import by.tc.task04.command.Routing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "controller", value = "/controller")
public class ServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processCommand(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processCommand(request, response);
    }

    public static void processCommand(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandType = request.getParameter("command");
        request.setCharacterEncoding("UTF-8");

        if (commandType == null) {
            request.getRequestDispatcher(PagePath.ERROR_404_PAGE).forward(request, response);
        }

        Command command = CommandFactory.getInstance().getCommand(commandType);
        Routing routing;
        routing = command.execute(request, response);

        String resource = routing.getResource();
        switch (routing.getRoutingType()) {
            case FORWARD:
                request.getRequestDispatcher(resource).forward(request, response);
                break;
            case REDIRECT:
                response.sendRedirect(request.getContextPath() + resource);
                break;
            default:
                request.getRequestDispatcher(PagePath.ERROR_404_PAGE).forward(request, response);
        }
    }

}
