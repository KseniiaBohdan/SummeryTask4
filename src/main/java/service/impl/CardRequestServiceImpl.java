package service.impl;

import data.entity.Account;
import db.dao.CardRequestDao;
import db.dao.impl.CardRequestDaoImpl;
import data.entity.CardRequest;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import db.transaction.impl.JdbcTransactionManager;
import service.CardRequestService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CardRequestServiceImpl implements CardRequestService {

    private CardRequestDao cardRequestDao = new CardRequestDaoImpl();
    private TransactionManager transactionManager = new JdbcTransactionManager();

    public boolean update(final CardRequest cardRequest) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return cardRequestDao.update(connection, cardRequest);
            }
        });
    }

    public boolean create(final CardRequest cardRequest) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return cardRequestDao.create(connection, cardRequest);
            }
        });
    }

    public List<CardRequest> getAll() {
        return transactionManager.execute(new TransactionOperation<List<CardRequest>>() {
            @Override
            public List<CardRequest> execute(Connection connection) {
                return cardRequestDao.getAll(connection);
            }
        });
    }

    public boolean deleteAll() {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return cardRequestDao.deleteAll(connection);
            }
        });
    }

    public boolean update(List<CardRequest> entity) {
        return false;
    }

    public boolean deleteByCardNumber(final Long cardNumber) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection)   {
                return cardRequestDao.deleteByCardNumber(connection, cardNumber);
            }
        });
    }

}
