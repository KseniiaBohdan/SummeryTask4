package db.transaction;

import java.sql.SQLException;

public interface TransactionManager {

    /**
     * Execute transaction
     *
     * @param op
     * @return
     * @throws SQLException
     */
    <E> E execute(TransactionOperation<E> op);
}
