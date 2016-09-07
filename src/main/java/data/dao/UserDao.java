package data.dao;

import data.entity.User;

import java.util.List;

public interface UserDao extends Dao<User> {

    public User getByEmail(String email);

    public boolean update(User user);

    public boolean create(User user);

    public User getById(Long id);

    public List<User> getAll();

    public boolean deleteById(Long id);

    public boolean deleteAll();

    public User getByCardNumber(long cardNumber);

    public List<User> getByStatus(Integer statusId);

    public User getByPhoneNumber(String phoneNumber);
}
