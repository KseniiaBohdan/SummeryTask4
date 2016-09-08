package db.dao;

import data.entity.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao extends Dao<User> {

    User getByEmail(Connection con, String email);

    boolean update(Connection con, User user);

    boolean create(Connection con, User user);

    User getById(Connection con, Long id);

    List<User> getAll(Connection con);

    boolean deleteById(Connection con, Long id);

    boolean deleteAll(Connection con);

    User getByCardNumber(Connection con, long cardNumber);

    List<User> getByStatus(Connection con, Integer statusId);

    User getByPhoneNumber(Connection con, String phoneNumber);
}
