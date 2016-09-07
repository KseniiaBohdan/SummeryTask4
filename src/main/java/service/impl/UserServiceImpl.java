package service.impl;

import data.entity.User;
import db.dao.impl.UserDaoImpl;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;
import db.transaction.impl.JdbcTransactionManager;
import service.UserService;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserDaoImpl userDao = new UserDaoImpl();
    private TransactionManager transactionManager = new JdbcTransactionManager();


    public User getById(final Long id) {
        return transactionManager.execute(new TransactionOperation<User>() {
            @Override
            public User execute(Connection connection) {
                return userDao.getById(connection, id);
            }
        });
    }

    public boolean deleteById(final Long id) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return userDao.deleteById(connection, id);
            }
        });
    }

    public User getByEmail(final String email) {
        return transactionManager.execute(new TransactionOperation<User>() {
            @Override
            public User execute(Connection connection) {
                return userDao.getByEmail(connection, email);
            }
        });
    }

    public User getByCardNumber(final long cardNumber) {
        return transactionManager.execute(new TransactionOperation<User>() {
            @Override
            public User execute(Connection connection) {
                return userDao.getByCardNumber(connection, cardNumber);
            }
        });
    }

    public List<User> getByStatus(final Integer statusId) {
        return transactionManager.execute(new TransactionOperation<List<User>>() {
            @Override
            public List<User> execute(Connection connection) {
                return userDao.getByStatus(connection, statusId);
            }
        });
    }

    public User getByPhoneNumber(final String phoneNumber) {
        return transactionManager.execute(new TransactionOperation<User>() {
            @Override
            public User execute(Connection connection) {
                return userDao.getByPhoneNumber(connection, phoneNumber);
            }
        });
    }

    public boolean update(final User user) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return userDao.update(connection, user);
            }
        });
    }

    public boolean create(final User user) {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return userDao.create(connection, user);
            }
        });
    }

    public List<User> getAll() {
        return transactionManager.execute(new TransactionOperation<List<User>>() {
            @Override
            public List<User> execute(Connection connection) {
                return userDao.getAll(connection);
            }
        });
    }

    public List<User> getAllUsers() {
        return transactionManager.execute(new TransactionOperation<List<User>>() {
            @Override
            public List<User> execute(Connection connection) {
                return userDao.getAllUsers(connection);
            }
        });
    }

    public boolean deleteAll() {
        return transactionManager.execute(new TransactionOperation<Boolean>() {
            @Override
            public Boolean execute(Connection connection) {
                return userDao.deleteAll(connection);
            }
        });
    }

    public boolean update(List<User> entity) {
        return false;
    }

    public List<User> findByName(final List<String> name) {
        return transactionManager.execute(new TransactionOperation<List<User>>() {
            @Override
            public List<User> execute(Connection connection) {
                List<User> users = userDao.findByName(connection, name.get(0));
                for (int i = 1; i < name.size(); i++) {
                    List<User> temp = userDao.findByName(connection, name.get(i));
                    for (int j = 0; j < temp.size(); j++) {
                        if (!users.contains(temp.get(j))) {
                            users.remove(temp.get(j));
                        }
                    }
                }
                return users;
            }
        });

    }

}