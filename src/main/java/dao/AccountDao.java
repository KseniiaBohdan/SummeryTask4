package dao;

import entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao extends Dao<Account> {
    public List<Account> deleteByUserId(Long userId) throws SQLException;
}
