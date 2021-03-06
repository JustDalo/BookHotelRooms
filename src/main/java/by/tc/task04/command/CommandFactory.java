package by.tc.task04.command;

import by.tc.task04.command.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {
    private static final Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {
        commands.put(CommandName.HOME_COMMAND, new HomeCommand());
        commands.put(CommandName.REGISTER_COMMAND, new RegisterCommand());
        commands.put(CommandName.SHOW_REGISTER_COMMAND, new ShowRegisterCommand());
        commands.put(CommandName.LOGIN_COMMAND, new LoginCommand());
        commands.put(CommandName.SHOW_LOGIN_COMMAND, new ShowLoginCommand());
        commands.put(CommandName.LOGOUT_COMMAND, new LogoutCommand());

        commands.put(CommandName.SHOW_HOTEL_ROOM_COMMAND, new ShowHotelRoomCommand());

        commands.put(CommandName.BOOK_ROOM_COMMAND, new BookRoomCommand());
        commands.put(CommandName.SHOW_BOOK_COMMAND, new ShowBookRoomCommand());
        commands.put(CommandName.SHOW_ALL_BOOKINGS, new ShowAllBookingsCommand());
        commands.put(CommandName.SHOW_MY_BOOKINGS, new ShowMyBookingsCommand());


        commands.put(CommandName.SHOW_ERROR_404_PAGE_COMMAND, new ShowError404PageCommand());
        commands.put(CommandName.SHOW_ERROR_500_PAGE_COMMAND, new ShowError500PageCommand());
    }

    public static CommandFactory getInstance() {
        return Holder.INSTANCE;
    }

    public Command getCommand(String name) {
        return Optional.ofNullable(commands.get(name)).orElse(commands.get(CommandName.DEFAULT_COMMAND));
    }

    public boolean commandExists(String commandName) {
        return commands.containsKey(commandName);
    }

    private static class Holder {
        static final CommandFactory INSTANCE = new CommandFactory();
    }
}
