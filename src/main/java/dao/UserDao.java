package dao;

import entity.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao<User> {

    public User getByEmail(String email) throws SQLException, ClassNotFoundException;

    public boolean update(User user) throws SQLException;

    public boolean create(User user) throws SQLException;

    public User getById(Long id) throws SQLException;

    public List<User> getAll() throws SQLException;

    public boolean deleteById(Long id) throws SQLException;

    public boolean deleteAll() throws SQLException;

    public User getByCardNumber(long cardNumber) throws SQLException;

    public List<User> getByStatus(Integer statusId) throws SQLException;

    public User getByPhoneNumber(String phoneNumber) throws SQLException;
}
