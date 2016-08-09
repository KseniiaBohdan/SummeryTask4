package service;

import entity.User;
import service.implementation.UserServiceImpl;

public class Test {

    public static void main(String[] args) {
        String email = "root";
        String password = "root";
        UserServiceImpl service = new UserServiceImpl();
        User user = null;
        try {
            user = service.getByEmail(email);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (user != null && user.getPassword().equals(password)) {
            System.out.print("OK");
        } else {
            System.out.print("!!!");
        }
    }
}
