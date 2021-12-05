package by.tc.task04.command;

import by.tc.task04.command.impl.HomeCommand;
import by.tc.task04.command.impl.RegisterCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {
    private static final Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {

        commands.put(CommandName.REGISTER_COMMAND, new RegisterCommand());
        commands.put(CommandName.HOME_COMMAND, new HomeCommand());
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
