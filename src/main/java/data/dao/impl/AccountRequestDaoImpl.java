package data.dao.impl;

import constant.dbConstant.DbFieldConstant;
import data.dao.AccountRequestDao;
import data.entity.Account;
import data.entity.AccountRequest;
import dbConnection.ConnectionPool;
import org.apache.taglibs.standard.tag.common.core.RedirectSupport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRequestDaoImpl implements AccountRequestDao {

    private static final String CREATE= "INSERT INTO account_request (account_id, title) VALUES (?, ?)";
    private static final String DELETE_BY_ACCOUNT_ID= "DELETE FROM account_request WHERE account_id = ?";
    private static final String GET_ALL= "SELECT * FROM account_request";

    public boolean create(AccountRequest accountRequest) {
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE);
            ps.setLong(1, accountRequest.getAccountId());
            ps.setString(2, accountRequest.getTitle());
            int result = ps.executeUpdate();
            ps.close();
            con.close();
            return (result>0);
        } catch (SQLException e) {
            return false;
        }
    }

    public List<AccountRequest> getAll() {
        Connection con = ConnectionPool.getConnection();
        List<AccountRequest> arList = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                AccountRequest ar = getAccountRequest(rs);
                arList.add(ar);
            }
            rs.close();
            ps.close();
            con.close();
            return arList;
        } catch (SQLException e) {
            return arList;
        }
    }

    public boolean deleteByAccountId(Long accountId) {
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_BY_ACCOUNT_ID);
            ps.setLong(1, accountId);
            int result = ps.executeUpdate();
            ps.close();
            con.close();
            return result>0;
        } catch (SQLException e) {
         return false;
        }
    }

    public boolean deleteAll() {
        return false;
    }

    public boolean update(AccountRequest accountRequest) {
        return false;
    }

    private AccountRequest getAccountRequest(ResultSet rs) throws SQLException {
        AccountRequest ar = new AccountRequest();
        ar.setId(rs.getLong(DbFieldConstant.ID));
        ar.setAccountId(rs.getLong(DbFieldConstant.ACCOUNT_ID));
        ar.setTitle(rs.getString(DbFieldConstant.TITLE));
        return ar;
    }
}
