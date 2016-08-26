package data.dao;

import data.entity.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao<User> {

    public User getByEmail(String email) throws SQLException, ClassNotFoundException;

    public boolean update(User user);

    public boolean create(User user);

    public User getById(Long id) throws SQLException;

    public List<User> getAll();

    public boolean deleteById(Long id) throws SQLException;

    public boolean deleteAll();

    public User getByCardNumber(long cardNumber) throws SQLException;

    public List<User> getByStatus(Integer statusId) throws SQLException;

    public User getByPhoneNumber(String phoneNumber) throws SQLException;
}
