package service.implementation;

import entity.Account;
import service.AccountService;

import java.sql.SQLException;
import java.util.List;


public class AccountServiceImpl implements AccountService {

    public boolean update(Account account) throws SQLException {
        return false;
    }

    public boolean create(Account account) {
        return false;
    }

    public List<Account> getAll() {
        return null;
    }

    public boolean deleteAll() {
        return false;
    }
}
