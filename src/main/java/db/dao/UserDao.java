package db.dao;

import data.entity.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao extends Dao<User> {

    public User getByEmail(Connection con, String email);

    public boolean update(Connection con, User user);

    public boolean create(Connection con, User user);

    public User getById(Connection con, Long id);

    public List<User> getAll(Connection con);

    public boolean deleteById(Connection con, Long id);

    public boolean deleteAll(Connection con);

    public User getByCardNumber(Connection con, long cardNumber);

    public List<User> getByStatus(Connection con, Integer statusId);

    public User getByPhoneNumber(Connection con, String phoneNumber);
}
