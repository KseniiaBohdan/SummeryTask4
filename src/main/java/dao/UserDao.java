package dao;

import entity.User;

import java.sql.SQLException;

public interface UserDao extends Dao<User>{

    public User getByEmail(String email) throws SQLException, ClassNotFoundException;
}
