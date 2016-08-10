package dao.implementation;

import dao.AccountDao;
import dbConnection.ConnectionPool;
import entity.Account;
import entity.BlockStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private static final String GET_BY_USER_ID = "SELECT * FROM account WHERE user_id = ?";
    private static final String CREATE = "INSERT INTO account (id, user_id, balance, number, status, title)" +
            "VALUES (?, ?, ?, ?, ?, ?)";

    public boolean update(Account account) {
        return false;
    }

    public boolean create(Account account) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(CREATE);
        ps.setLong(1, account.getId());
        ps.setLong(2, account.getUserId());
        ps.setLong(3, account.getBalance());
        ps.setInt(4, account.getNumber());
        ps.setString(5, account.getStatus().toString());
        ps.setString(6, account.getTitle());
        ps.executeUpdate();
        return true;
    }

    public Account getById(Long id) {
        return null;
    }

    public List<Account> getAll() {
        return null;
    }

    public boolean deleteById(Long id) {
        return false;
    }

    public boolean deleteAll() {
        return false;
    }

    public List<Account> deleteByUserId(Long userId) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_USER_ID);
        ps.setLong(1, userId);
        List accountList = new ArrayList<Account>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Account account = new Account(rs.getLong("id"), rs.getLong("user_id"), rs.getLong("balance"), rs.getInt("number"),
                    BlockStatus.valueOf(rs.getString("status")), rs.getString("title"));
            accountList.add(account);
        }
        return accountList;
    }
}
