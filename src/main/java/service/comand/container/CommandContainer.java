package service.comand.container;

import service.comand.Command;
import service.comand.impl.BlockUserCommand;
import service.comand.impl.DeleteUserCommand;
import service.comand.impl.UnblockUserCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandContainer {

    private CommandContainer() {
    }

    private static final Map<String, Command> userCommands = new HashMap() {{
        put(CommandConstant.BLOCK_USER, new BlockUserCommand());
        put(CommandConstant.UNBLOCK_USER, new UnblockUserCommand());
        put(CommandConstant.DELETE_USER, new DeleteUserCommand());
    }};

    public static Command getUserCommand(String command) {
        return userCommands.get(command);
    }
}
