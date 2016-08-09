package service.implementation;

import entity.Entity;
import entity.Role;
import service.RoleService;

import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    public boolean update(Role role) throws SQLException {
        return false;
    }

    public boolean create(Role role) {
        return false;
    }

    public List<Role> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }
}
