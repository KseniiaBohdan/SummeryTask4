package dao;

import entity.Role;

import java.sql.SQLException;

public interface RoleDao extends Dao<Role> {

    public boolean deleteById(Integer id) throws SQLException;
}
