package db.dao;

import data.entity.AccountRequest;

import java.sql.Connection;

public interface AccountRequestDao extends Dao<AccountRequest>{

    boolean deleteByAccountId(Connection con, Long accountId);
}
