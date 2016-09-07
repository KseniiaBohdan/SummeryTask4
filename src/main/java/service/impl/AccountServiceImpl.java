package service.impl;

import data.entity.Account;
import data.entity.Status;
import db.dao.impl.AccountDaoImpl;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import db.transaction.impl.JdbcTransactionManager;
import service.AccountService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class AccountServiceImpl implements AccountService {

    private AccountDaoImpl accountDao = new AccountDaoImpl();
    private TransactionManager transactionManager = new JdbcTransactionManager();


    public boolean update(final Account account) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) throws SQLException {
                return accountDao.update(connection, account);
            }
        });
    }

    @Override
    public boolean create(Account account) {
        return false;
    }

    public boolean create(final Account account, final Long userId) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) throws SQLException {
                int accountNumber = accountDao.getByUserId(connection, userId).size() + 1;
                account.setNumber(accountNumber);
                if (accountValid(connection, account)) {
                    return accountDao.create(connection, account);
                } else {
                    return false;
                }
            }
        });
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

    public List<Account> getByUserId(final Long userId) {
        return transactionManager.execute(new TransactionOperation<List<Account>>() {
            @Override
            public List<Account> execute(Connection connection) throws SQLException {
                return accountDao.getByUserId(connection, userId);
            }
        });
    }

    public Account getByAccountId(final Long id) {
        return transactionManager.execute(new TransactionOperation<Account>() {
            @Override
            public Account execute(Connection connection) throws SQLException {
                return accountDao.getById(connection, id);
            }
        });
    }

    public boolean deleteById(final Long accountId) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) throws SQLException {
                return accountDao.deleteById(connection, accountId);
            }
        });
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

    private static boolean accountValid(Connection connection, Account account) {
        if (new AccountDaoImpl().getById(connection, account.getId()) == null) {
            return true;
        } else {
            return false;
        }
    }

}
