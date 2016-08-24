package data.dao.impl;

import constant.dbConstant.DbFieldConstant;
import data.dao.AccountDao;
import dbConnection.ConnectionPool;
import data.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private static final String GET_BY_USER_ID = "SELECT * FROM account WHERE user_id = ?";
    private static final String CREATE = "INSERT INTO account (id, balance, number, status_id, title, user_id)" +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_BY_ACCOUNT_ID = "SELECT * FROM account WHERE id = ?";
    private static final String DELETE_BY_ID = "UPDATE account SET status_id = 3 WHERE id = ?";
    private static final String UPDATE = "UPDATE account SET balance = ?, status_id = ?, title = ? WHERE id = ?";

    public boolean update(Account account) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(UPDATE);
        ps.setLong(1, account.getBalance());
        ps.setInt(2, account.getStatus().getId());
        ps.setString(3, account.getTitle());
        ps.setLong(4, account.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
        return true;
    }

    public boolean create(Account account) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(CREATE);
        ps.setLong(1, account.getId());
        ps.setLong(2, account.getBalance());
        ps.setInt(3, account.getNumber());
        ps.setInt(4, account.getStatus().getId());
        ps.setString(5, account.getTitle());
        ps.setLong(6, account.getUserId());
        ps.executeUpdate();
        ps.close();
        con.close();
        return true;
    }

    public Account getById(Long id) {
        Account account = null;
        try {
            Connection con = ConnectionPool.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_BY_ACCOUNT_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                account = new Account();
                account = getAccount(rs);
                rs.close();
                ps.close();
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> getAll() {
        return null;
    }

    public boolean deleteById(Long id){
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_BY_ID);
            ps.setLong(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteAll() {
        return false;
    }

    public List<Account> getByUserId(Long userId) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_USER_ID);
        ps.setLong(1, userId);
        List accountList = new ArrayList<Account>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Account account = getAccount(rs);
            accountList.add(account);
        }
        rs.close();
        ps.close();
        con.close();
        return accountList;
    }

    private Account getAccount(ResultSet rs) throws SQLException {
        Account account = new Account();
        account.setId(rs.getLong(DbFieldConstant.ID));
        account.setBalance(rs.getLong(DbFieldConstant.BALANCE));
        account.setNumber(rs.getInt(DbFieldConstant.NUMBER));
        account.setStatus(rs.getInt(DbFieldConstant.STATUS_ID));
        account.setTitle(rs.getString(DbFieldConstant.TITLE));
        account.setUserId(rs.getLong(DbFieldConstant.USER_ID));
        return account;
    }
}
