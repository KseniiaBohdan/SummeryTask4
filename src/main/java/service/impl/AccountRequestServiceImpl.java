package service.impl;

import data.dao.AccountRequestDao;
import data.dao.impl.AccountRequestDaoImpl;
import data.entity.AccountRequest;
import service.AccountRequestService;

import java.util.List;

public class AccountRequestServiceImpl implements AccountRequestService{

    private static AccountRequestDao accountRequestDao = new AccountRequestDaoImpl();

    public boolean create(AccountRequest accountRequest) {
        return accountRequestDao.create(accountRequest);
    }

    public List<AccountRequest> getAll() {
        return accountRequestDao.getAll();
    }

    public boolean deleteByAccountId(Long accountId) {
        return accountRequestDao.deleteByAccountId(accountId);
    }

    public boolean update(AccountRequest accountRequest) {
        return false;
    }

    public boolean deleteAll() {
        return false;
    }

    public boolean update(List<AccountRequest> entity) {
        return false;
    }

}
