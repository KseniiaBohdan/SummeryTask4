package service;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends Service<User> {

    public User getById(Long id);

    public boolean deleteById(Long id);

    public User getByEmail(String email) throws ClassNotFoundException;

    public User getByCardNumber(long cardNumber);

    public List<User> getByStatus(String status) throws SQLException;

    public User getByPhoneNumber(String phoneNumber) throws SQLException;

    public boolean update(User user) throws SQLException;

    public boolean create(User user);

    public List<User> getAll();

    public boolean deleteAll();
}
