package db.dao;

import data.entity.Account;

import java.sql.Connection;
import java.util.List;

public interface AccountDao extends Dao<Account> {
    public List<Account> getByUserId(Connection con, Long userId);
}
