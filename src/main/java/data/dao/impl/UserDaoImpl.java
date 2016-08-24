package data.dao.impl;

import constant.dbConstant.DbFieldConstant;
import data.dao.UserDao;
import dbConnection.ConnectionPool;
import data.entity.Role;
import data.entity.Status;
import data.entity.User;

import java.sql.*;
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


    public User getByEmail(String email) throws SQLException, ClassNotFoundException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_EMAIL);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = getUser(rs);
            rs.close();
            ps.close();
            con.close();
            return user;
        }
        return null;
    }


    public boolean update(User user) throws SQLException {
        Connection con = ConnectionPool.getConnection();
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
        ps.close();
        con.close();
        return true;
    }

    public boolean create(User user) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getSecondName());
        ps.setString(3, user.getPatronymic());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPassword());
        ps.setInt(6, 1); //method  get bla bla
        ps.setInt(7, 2);
        ps.setString(8, user.getPhoneNumber());
        ps.executeUpdate();
        ps.close();
        con.close();
        return true;
    }

    public User getById(Long id) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        User user = new User();
        while (rs.next()) {
            user = getUser(rs);
        }
        rs.close();
        ps.close();
        con.close();
        return user;
    }

    public List<User> getAll() throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_ALL);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList();
        while (rs.next()) {
            User user = getUser(rs);
            userList.add(user);
        }
        rs.close();
        ps.close();
        con.close();
        return userList;
    }

    public boolean deleteById(Long id){
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_BY_ID);
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteAll(){
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE_ALL);
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public User getByCardNumber(long cardNumber) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_USER_ID_BY_CARD_NUMBER);
        ps.setLong(1, cardNumber);
        ResultSet rs = ps.executeQuery();
        Long id = 0L;
        while (rs.next()) {
            id = rs.getLong(DbFieldConstant.ID);
        }
        rs.close();
        ps.close();
        con.close();
        return getById(id);
    }

    public List<User> getByStatus(Integer statusId) throws SQLException {
        List<User> userList = new ArrayList();
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_STATUS);
        ps.setInt(1, statusId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = getUser(rs);
            userList.add(user);
        }
        rs.close();
        ps.close();
        con.close();
        return userList;
    }

    public User getByPhoneNumber(String phoneNumber) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_PHONE_NUMBER);
        ps.setString(1, phoneNumber);
        ResultSet rs = ps.executeQuery();
        User user = new User();
        while (rs.next()) {
            user = getUser(rs);
            rs.close();
            ps.close();
            con.close();
        }
        return user;
    }

    public List<User> getAllUsers() throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_ALL_USERS);
        ps.setInt(1, Role.USER.getId());
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList();
        User user = new User();
        while (rs.next()) {
            user = getUser(rs);
            userList.add(user);
        }
        rs.close();
        ps.close();
        con.close();
        return userList;
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
