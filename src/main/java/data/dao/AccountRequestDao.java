package data.dao;

import data.entity.AccountRequest;

public interface AccountRequestDao extends Dao<AccountRequest>{

    boolean deleteByAccountId(Long accountId);
}
