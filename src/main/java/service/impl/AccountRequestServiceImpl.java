package service.impl;

import db.dao.AccountRequestDao;
import db.dao.impl.AccountRequestDaoImpl;
import data.entity.AccountRequest;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import db.transaction.impl.JdbcTransactionManager;
import service.AccountRequestService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AccountRequestServiceImpl implements AccountRequestService {

    private TransactionManager transactionManager = new JdbcTransactionManager();

    private static AccountRequestDao accountRequestDao = new AccountRequestDaoImpl();

    public boolean create(final AccountRequest accountRequest) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) throws SQLException {
                return accountRequestDao.create(connection, accountRequest);
            }
        });
    }

    public List<AccountRequest> getAll() {
        return transactionManager.execute(new TransactionOperation<List<AccountRequest>>() {
            @Override
            public List<AccountRequest> execute(Connection connection) throws SQLException {
                return accountRequestDao.getAll(connection);
            }
        });
    }

    public boolean deleteByAccountId(final Long accountId) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) throws SQLException {
                return accountRequestDao.deleteByAccountId(connection, accountId);
            }
        });
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
