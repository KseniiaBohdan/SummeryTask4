package service.impl;

import data.dao.impl.AccountDaoImpl;
import data.entity.Account;
import data.entity.Status;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;


public class AccountServiceImpl implements AccountService {

    AccountDaoImpl accountDao = new AccountDaoImpl();

    public boolean update(Account account) {
        return accountDao.update(account);
    }

    public boolean create(Account account) {
        return accountDao.create(account);
    }

    public List<Account> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }

    public boolean update(List<Account> entity) {
        return false;
    }

    public List<Account> getByUserId(Long userId) {
            return accountDao.getByUserId(userId);
    }

    public Account getByAccountId(Long id) {
        return accountDao.getById(id);
    }

    public boolean deleteById(Long accountId) {
        return accountDao.deleteById(accountId);
    }

    public void removeAccountByStatus(List<Account> accountList, Status... status) {
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < accountList.size(); j++) {
                if (accountList.get(j).getStatus().equals(status[i])) {
                    accountList.remove(j);
                    --j;
                }
            }
        }
    }

}
