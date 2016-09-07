package db.dao.impl;

import db.dbConstant.DbFieldConstant;
import db.dao.AccountDao;
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

    public boolean update(Connection con, Account account) {
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE);
            ps.setLong(1, account.getBalance());
            ps.setInt(2, account.getStatus().getId());
            ps.setString(3, account.getTitle());
            ps.setLong(4, account.getId());
            int result = ps.executeUpdate();
            closeAll(ps);
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean create(Connection con, Account account) {
        try {
            PreparedStatement ps = con.prepareStatement(CREATE);
            ps.setLong(1, account.getId());
            ps.setLong(2, account.getBalance());
            ps.setInt(3, account.getNumber());
            ps.setInt(4, account.getStatus().getId());
            ps.setString(5, account.getTitle());
            ps.setLong(6, account.getUserId());
            ps.executeUpdate();
            closeAll(ps);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Account getById(Connection con, Long id) {
        Account account = null;
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ACCOUNT_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = getAccount(rs);
            }
            closeAll(ps, rs);
            return account;
        } catch (SQLException e) {
            return account;
        }
    }

    public List<Account> getAll(Connection con) {
        return null;
    }

    public boolean deleteById(Connection con, Long id) {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_BY_ID);
            ps.setLong(1, id);
            int result = ps.executeUpdate();
            closeAll(ps);
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteAll(Connection con) {
        return false;
    }

    public List<Account> getByUserId(Connection con, Long userId) {
        List<Account> accountList = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_USER_ID);
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = getAccount(rs);
                accountList.add(account);
            }
            closeAll(ps, rs);
            return accountList;
        } catch (SQLException e) {
            return accountList;
        }
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

    private void closeAll(PreparedStatement ps, ResultSet... rs) throws SQLException {
        for (int i = 0; i < rs.length; i++) {
            rs[i].close();
        }
        ps.close();
    }
}
