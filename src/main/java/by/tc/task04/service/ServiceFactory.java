package by.tc.task04.service;

import by.tc.task04.service.impl.UserServiceImpl;

public class ServiceFactory {
    private final UserService userService = new UserServiceImpl();

    private ServiceFactory() {

    }

    public UserService getUserService() {
        return userService;
    }

    public static ServiceFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final ServiceFactory INSTANCE = new ServiceFactory();
    }
}
