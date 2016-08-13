package dao.implementation;

import dao.RoleDao;
import dbConnection.ConnectionPool;
import entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    private static final String GET_ALL = "SELECT * FROM role";
    private static final String DELETE_ALL = "";
    private static final String GET_BY_ID = "SELECT * FROM role WHERE id = ?";
    private static final String DELETE_BY_ID = "";
    private static final String CREATE = "INSERT INTO role (id, role_name) VALUES (?, ?)";

    public boolean update(Role role) {
        return false;
    }

    public boolean create(Role role) {
        return false;
    }

    public Role getById(Long id) {
        return null;
    }

    public List<Role> getAll() throws SQLException {
        List<Role> roleList = new ArrayList();
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_ALL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            roleList.add(new Role(rs.getInt(1), rs.getString(2)));
        }
        return roleList;
    }

    public boolean deleteById(Integer id) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(DELETE_BY_ID);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        con.close();
        return true;
    }

    public boolean deleteAll() {
        return false;
    }
}
