package by.tc.task04.command.impl;

import by.tc.task04.command.Command;
import by.tc.task04.command.PagePath;
import by.tc.task04.command.Routing;
import by.tc.task04.command.RoutingType;
import by.tc.task04.entity.User;
import by.tc.task04.service.UserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand implements Command {

    public RegisterCommand() {

    }

    @Override
    public Routing execute(HttpServletRequest request, HttpServletResponse response) {
        return null;

    }
}
