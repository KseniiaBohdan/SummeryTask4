package service.impl;

import data.entity.Account;
import db.dao.AtmDao;
import db.dao.impl.AtmDaoImpl;
import data.entity.Atm;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import db.transaction.impl.JdbcTransactionManager;
import service.AtmService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AtmServiceImpl implements AtmService{

    private AtmDao atmDao = new AtmDaoImpl();
    private TransactionManager transactionManager = new JdbcTransactionManager();

    public boolean create(final Atm atm) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection){
                return atmDao.create(connection, atm);
            }
        });
    }

    public boolean update(Atm atm) {
        return false;
    }

    public List<Atm> getAll() {
        return transactionManager.execute(new TransactionOperation<List<Atm>>() {
            @Override
            public List<Atm> execute(Connection connection) {
                return atmDao.getAll(connection);
            }
        });
    }

    public boolean deleteAll() {
        return false;
    }

    public boolean update(List<Atm> entity) {
        return false;
    }

    public List<Atm> getByUserId(final Long userId) {
        return transactionManager.execute(new TransactionOperation<List<Atm>>() {
            @Override
            public List<Atm> execute(Connection connection)  {
                return atmDao.getByUserId(connection, userId);
            }
        });
    }
}
