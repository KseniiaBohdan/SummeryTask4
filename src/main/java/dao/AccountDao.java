package dao;

import entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao extends Dao<Account> {
    public List<Account> getByUserId(Long userId) throws SQLException;
}
