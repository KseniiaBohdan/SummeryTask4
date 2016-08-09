package service.implementation;

import dao.UserDao;
import dao.implementation.UserDaoImpl;
import dbConnection.ConnectionPool;
import entity.Entity;
import entity.User;
import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        try {
            return userDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getByEmail(String email) throws ClassNotFoundException {
        try {
            User user = userDao.getByEmail(email);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getByCardNumber(long cardNumber){
        try {
            return userDao.getByCardNumber(cardNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getByStatus(String status) throws SQLException {
        return userDao.getByStatus(status);
    }

    public User getByPhoneNumber(String phoneNumber) throws SQLException {
            return userDao.getByPhoneNumber(phoneNumber);
    }

    public boolean update(User user) throws SQLException {
        return userDao.update(user);
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

    public boolean deleteAll() {
        try {
            return userDao.deleteAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
