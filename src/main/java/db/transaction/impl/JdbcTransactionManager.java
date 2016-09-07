package db.transaction.impl;

import db.dbConnection.ConnectionPool;
import db.transaction.TransactionManager;
import db.transaction.TransactionOperation;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTransactionManager implements TransactionManager {

    public <E> E execute(TransactionOperation<E> operation) {
        Connection connection = ConnectionPool.getFreeConnection();

        E result = null;
        try {
            connection.setTransactionIsolation(operation.getLevel());
            result = operation.execute(connection);
//            connection.commit();
            ConnectionPool.putUnusedConnection(connection);
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        return result;
    }
}
