package service;

import data.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends Service<User> {

    public User getById(Long id);
    public List<User> getAllUsers();

    public boolean deleteById(Long id);

    public User getByEmail(String email) throws ClassNotFoundException;

    public User getByCardNumber(long cardNumber);

    public List<User> getByStatus(Integer statusId) throws SQLException;

    public User getByPhoneNumber(String phoneNumber) throws SQLException;

    public boolean update(User user);

    public boolean create(User user);

    public List<User> getAll();

    public boolean deleteAll();
}
