package service.comand.impl;

import data.entity.Status;
import data.entity.User;
import service.UserService;
import service.comand.Command;
import service.implementation.UserServiceImpl;

import javax.naming.Context;
import java.util.Map;

public class BlockUserCommand implements Command {

    public Object execute(Context context, Map<String, Object> params) {
        Long id = Long.valueOf(params.get("id").toString());
        UserService userService = new UserServiceImpl();
        User user = userService.getById(id);
        user.setStatus(Status.BLOCKED);
        userService.update(user);
        return user;
    }
}
