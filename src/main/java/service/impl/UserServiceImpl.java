package service.impl;

import data.dao.impl.UserDaoImpl;
import data.entity.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDaoImpl userDao = new UserDaoImpl();

    public User getById(Long id) {
        return userDao.getById(id);
    }

    public boolean deleteById(Long id) {
        return userDao.deleteById(id);
    }

    public User getByEmail(String email) throws ClassNotFoundException {
        try {
            User user = userDao.getByEmail(email);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getByCardNumber(long cardNumber) {
        return userDao.getByCardNumber(cardNumber);
    }

    public List<User> getByStatus(Integer statusId) throws SQLException {
        return userDao.getByStatus(statusId);
    }

    public User getByPhoneNumber(String phoneNumber) throws SQLException {
        return userDao.getByPhoneNumber(phoneNumber);
    }

    public boolean update(User user) {
        return userDao.update(user);
    }

    public boolean create(User user) {
            return userDao.create(user);
    }

    public List<User> getAll() {
            return userDao.getAll();
    }

    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteAll() {
        return userDao.deleteAll();
    }
}