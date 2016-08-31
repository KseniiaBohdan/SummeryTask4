package service.comand.impl;

import data.entity.Status;
import data.entity.User;
import service.UserService;
import service.comand.Command;
import service.impl.UserServiceImpl;

import javax.naming.Context;
import java.util.Map;

public class BlockUserCommand implements Command {

    private static final String USER_ID = "userId";

    public Object execute(Context context, Map<String, Object> params) {
        Long id = Long.valueOf(params.get(USER_ID).toString());
        UserService userService = new UserServiceImpl();
        User user = userService.getById(id);
        user.setStatus(Status.BLOCKED);
        userService.update(user);
        return user;
    }
}
