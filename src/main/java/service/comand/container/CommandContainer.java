package service.comand.container;

import service.comand.Command;
import service.comand.impl.BlockUserCommand;
import service.comand.impl.DeleteUserCommand;
import service.comand.impl.UnblockCardCommand;
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

    private static final Map<String, Command> cardCommands = new HashMap() {{
        put(CommandConstant.UNBLOCK_CARD, new UnblockCardCommand());
    }};

    public static Command getUserCommand(String command) {
        return userCommands.get(command);
    }

    public static Command getCardCommand(String command) {
        return cardCommands.get(command);
    }
}
