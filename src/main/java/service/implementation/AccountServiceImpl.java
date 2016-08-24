package service.implementation;

import data.dao.impl.AccountDaoImpl;
import data.entity.Account;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;


public class AccountServiceImpl implements AccountService {

    AccountDaoImpl accountDao = new AccountDaoImpl();

    public boolean update(Account account){
        try {
            return accountDao.update(account);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean create(Account account) {
        try {
            return accountDao.create(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Account> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }

    public List<Account> getByUserId(Long userId) {
        try {
            return accountDao.getByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getByAccountId(Long id) {
        return accountDao.getById(id);
    }

    public boolean deleteById(Long accountId) {
            return accountDao.deleteById(accountId);
    }
}
