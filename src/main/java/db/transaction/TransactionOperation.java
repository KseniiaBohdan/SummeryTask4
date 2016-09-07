package db.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class TransactionOperation<T> {
    private int level = Connection.TRANSACTION_READ_COMMITTED;

    /**
     * Execute operation
     *
     * @param connection
     * @return
     * @throws SQLException
     */
    public abstract T execute(Connection connection) throws SQLException;

    /**
     * Get transaction level
     *
     * @return
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set transaction level
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }
}
