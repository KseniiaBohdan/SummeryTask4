package service.implementation;

import data.dao.impl.UserDaoImpl;
import data.entity.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDaoImpl userDao = new UserDaoImpl();

    public User getById(Long id) {
        try {
            return userDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
        try {
            return userDao.getByCardNumber(cardNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getByStatus(Integer statusId) throws SQLException {
        return userDao.getByStatus(statusId);
    }

    public User getByPhoneNumber(String phoneNumber) throws SQLException {
        return userDao.getByPhoneNumber(phoneNumber);
    }

    public boolean update(User user) {
        try {
            return userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean create(User user) {
        try {
            return userDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<User> getAll() {
        try {
            return userDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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