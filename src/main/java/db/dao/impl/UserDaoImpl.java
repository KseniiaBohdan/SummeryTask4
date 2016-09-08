package db.dao.impl;

import data.entity.Role;
import data.entity.Status;
import data.entity.User;
import db.dao.UserDao;
import db.dbConstant.DbFieldConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String GET_BY_EMAIL = "SELECT * from user where email=?";
    private static final String GET_BY_PHONE_NUMBER = "SELECT * from user where phone_number=?";
    private static final String GET_BY_STATUS = "SELECT * from user where status_id=?";
    private static final String GET_USER_ID_BY_CARD_NUMBER = "SELECT user_id from card where card_number=?";
    private static final String GET_BY_ID = "SELECT * from user where id=?";
    private static final String DELETE_ALL = "DELETE * from user";
    private static final String DELETE_BY_ID = "DELETE * from user where id=?";
    private static final String GET_ALL = "SELECT * from user";
    private static final String GET_ALL_USERS = "SELECT * from user where role_id = ?";
    private static final String CREATE_USER = "INSERT into user (first_name, second_name, patronymic, email, password, status_id, role_id, phone_number) " +
            " values (?, ?, ?,?, ?, ?, ?, ?); ";
    private static final String UPDATE_USER = "UPDATE user SET first_name=?, second_name = ?, patronymic = ?, " +
            "email = ?, password = ?, status_id = ?, role_id = ?, phone_number = ?  WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM user WHERE first_name LIKE ? OR second_name LIKE ? OR " +
            "patronymic LIKE ? AND role_id = ?";

    public User getByEmail(Connection con, String email) {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_EMAIL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = getUser(rs);
            }
            closeAll(ps, rs);
            return user;
        } catch (SQLException e) {
            return user;
        }
    }

    private void closeAll(PreparedStatement ps, ResultSet... rs) throws SQLException {
        for (int i = 0; i < rs.length; i++) {
            rs[i].close();
        }
        ps.close();
    }

    public List<User> findByName(Connection con, String name) {
        List<User> users = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(FIND_BY_NAME);
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + name + "%");
            ps.setString(3, "%" + name + "%");
            ps.setInt(4, Role.USER.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = getUser(rs);
                users.add(u);
            }
            closeAll(ps, rs);
            return users;
        } catch (SQLException e) {
            return users;
        }
    }


    public boolean update(Connection con, User user) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE_USER);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSecondName());
            ps.setString(3, user.getPatronymic());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getStatus().getId());
            ps.setInt(7, user.getRole().getId());
            ps.setString(8, user.getPhoneNumber());
            ps.setLong(9, user.getId());
            ps.executeUpdate();
            closeAll(ps);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean create(Connection con, User user) {
        try {
            PreparedStatement ps = con.prepareStatement(CREATE_USER);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSecondName());
            ps.setString(3, user.getPatronymic());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getStatus().getId());
            ps.setInt(7, user.getRole().getId());
            ps.setString(8, user.getPhoneNumber());
            ps.executeUpdate();
            closeAll(ps);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public User getById(Connection con, Long id) {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = getUser(rs);
            }
            closeAll(ps, rs);
            return user;
        } catch (SQLException e) {
            return user;
        }
    }

    public List<User> getAll(Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            List<User> userList = new ArrayList();
            while (rs.next()) {
                User user = getUser(rs);
                userList.add(user);
            }
            closeAll(ps, rs);
            return userList;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean deleteById(Connection con, Long id) {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_BY_ID);
            ps.setLong(1, id);
            ps.executeUpdate();
            closeAll(ps);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteAll(Connection con) {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_ALL);
            ps.executeUpdate();
            closeAll(ps);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public User getByCardNumber(Connection con, long cardNumber) {
        try {
            PreparedStatement ps = con.prepareStatement(GET_USER_ID_BY_CARD_NUMBER);
            ps.setLong(1, cardNumber);
            ResultSet rs = ps.executeQuery();
            Long id = 0L;
            while (rs.next()) {
                id = rs.getLong(DbFieldConstant.USER_ID);
            }
            closeAll(ps, rs);
            return getById(con, id);
        } catch (SQLException e) {
            return null;
        }
    }

    public List<User> getByStatus(Connection con, Integer statusId) {
        List<User> userList = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_STATUS);
            ps.setInt(1, statusId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = getUser(rs);
                userList.add(user);
            }
            closeAll(ps, rs);
            return userList;
        } catch (SQLException e) {
            return userList;
        }
    }

    public User getByPhoneNumber(Connection con, String phoneNumber) {
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_PHONE_NUMBER);
            ps.setString(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = getUser(rs);
            }
            closeAll(ps, rs);
            return user;
        } catch (SQLException e) {
            return user;
        }
    }

    public List<User> getAllUsers(Connection con) {
        List<User> userList = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL_USERS);
            ps.setInt(1, Role.USER.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = getUser(rs);
                userList.add(user);
            }
            closeAll(ps, rs);
            return userList;
        } catch (SQLException e) {
            return userList;
        }
    }

    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong(DbFieldConstant.ID));
        user.setFirstName(rs.getString(DbFieldConstant.FIRST_NAME));
        user.setSecondName(rs.getString(DbFieldConstant.SECOND_NAME));
        user.setPatronymic(rs.getString(DbFieldConstant.PATRONYMIC));
        user.setEmail(rs.getString(DbFieldConstant.EMAIL));
        user.setPassword(rs.getString(DbFieldConstant.PASSWORD));
        user.setStatus(Status.getStatus(rs.getInt(DbFieldConstant.STATUS_ID)));
        user.setRole(Role.getRole(rs.getInt(DbFieldConstant.ROLE_ID)));
        user.setPhoneNumber(rs.getString(DbFieldConstant.PHONE_NUMBER));
        return user;
    }
}
