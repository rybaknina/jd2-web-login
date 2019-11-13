package by.htp.ts.command;

import by.htp.ts.command.impl.AuthorizationCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

    public CommandProvider() {
        commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
    }

    public Command getCommand(String name){
        CommandName commandName;

        commandName = CommandName.valueOf(name.toUpperCase());
        return commands.get(commandName);
    }

}
