package service.implementation;

import dao.implementation.AccountDaoImpl;
import entity.Account;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;


public class AccountServiceImpl implements AccountService {

    AccountDaoImpl accountDao = new AccountDaoImpl();

    public boolean update(Account account) throws SQLException {
        return false;
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
            return accountDao.deleteByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
