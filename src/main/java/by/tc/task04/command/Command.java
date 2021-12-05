package by.tc.task04.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    Routing execute(HttpServletRequest request, HttpServletResponse response);
}
