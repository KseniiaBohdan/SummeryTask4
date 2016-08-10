package service.implementation;

import dao.implementation.RoleDaoImpl;
import entity.Entity;
import entity.Role;
import service.RoleService;

import java.sql.SQLException;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    RoleDaoImpl roleDao = new RoleDaoImpl();

    public boolean update(Role role) {
        return roleDao.update(role);
    }

    public boolean create(Role role) {
        return roleDao.create(role);
    }

    public List<Role> getAll() {
        try {
            return roleDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteAll() {
        return roleDao.deleteAll();
    }
    public boolean deleteById(Integer id) {
        try {
            return roleDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
