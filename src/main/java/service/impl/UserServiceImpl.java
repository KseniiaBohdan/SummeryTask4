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

    public User getByEmail(String email) {
        User user = userDao.getByEmail(email);
        return user;
    }

    public User getByCardNumber(long cardNumber) {
        return userDao.getByCardNumber(cardNumber);
    }

    public List<User> getByStatus(Integer statusId) {
        return userDao.getByStatus(statusId);
    }

    public User getByPhoneNumber(String phoneNumber) {
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
        return userDao.getAllUsers();
    }

    public boolean deleteAll() {
        return userDao.deleteAll();
    }

    public boolean update(List<User> entity) {
        return false;
    }

    public List<User> findByName(List<String> name) {
        List<User> users = userDao.findByName(name.get(0));
        for (int i = 1; i < name.size(); i++) {
            List<User> temp = userDao.findByName(name.get(i));
            for (int j = 0; j < temp.size(); j++) {
                if (!users.contains(temp.get(j))) {
                    users.remove(temp.get(j));
                }
            }
        }
        return users;
    }

}