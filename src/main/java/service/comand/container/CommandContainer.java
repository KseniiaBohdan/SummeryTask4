package service.comand.container;

import service.comand.Command;
import service.comand.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandContainer {

    private CommandContainer() {
    }

    private static final Map<String, Command> userCommands = new HashMap() {{
        put(CommandConstant.BLOCK_USER, new BlockUserCommand());
        put(CommandConstant.UNBLOCK_USER, new UnblockUserCommand());
        put(CommandConstant.DELETE_USER, new DeleteUserCommand());
        put(CommandConstant.PROMOTE, new PromoteCommand());
        put(CommandConstant.DISMISS, new DismissCommand());
    }};

    private static final Map<String, Command> cardCommands = new HashMap() {{
        put(CommandConstant.UNBLOCK_CARD, new UnblockCardCommand());
    }};

    private static final Map<String, Command> accountCommands = new HashMap(){{
        put(CommandConstant.UNBLOCK_ACCOUNT, new UnblockAccountCommand());
    }};

    public static Command getUserCommand(String command) {
        return userCommands.get(command);
    }

    public static Command getCardCommand(String command) {
        return cardCommands.get(command);
    }

    public static Command getAccountCommand(String command) {
        return accountCommands.get(command);
    }
}
