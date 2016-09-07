package service.impl;

import data.entity.Payment;
import db.dao.PaymentDao;
import db.dao.impl.PaymentDaoImpl;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import db.transaction.impl.JdbcTransactionManager;
import service.PaymentService;

import java.sql.Connection;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private static PaymentDao paymentDao = new PaymentDaoImpl();
    private TransactionManager transactionManager = new JdbcTransactionManager();


    public boolean update(final Payment payment) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return paymentDao.update(connection, payment);
            }
        });
    }

    public boolean create(final Payment payment) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return paymentDao.create(connection, payment);
            }
        });
    }

    public List<Payment> getAll() {
        return transactionManager.execute(new TransactionOperation<List<Payment>>() {
            @Override
            public List<Payment> execute(Connection connection) {
                return paymentDao.getAll(connection);
            }
        });
    }

    public boolean deleteAll() {
        return false;
    }

    public boolean update(List<Payment> entity) {
        return false;
    }

    public List getByUserSenderId(final Long userId) {
        return transactionManager.execute(new TransactionOperation<List>() {
            @Override
            public List execute(Connection connection) {
                return paymentDao.getByUserSenderId(connection, userId);
            }
        });
    }

    public List getByCardSenderId(Long cardSenderId) {
        return null;
    }

    public List getByUserReceiverId(final Long userId) {
        return transactionManager.execute(new TransactionOperation<List>() {
            @Override
            public List execute(Connection connection) {
                return paymentDao.getByUserReceiverId(connection, userId);
            }
        });
    }

    public Payment getById(final Long id) {
        return transactionManager.execute(new TransactionOperation<Payment>() {
            @Override
            public Payment execute(Connection connection) {
                return paymentDao.getById(connection, id);
            }
        });
    }

}
