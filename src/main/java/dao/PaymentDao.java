package dao;

import entity.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDao extends Dao<Payment> {
    public List getByUserSenderId(Long userId) throws SQLException;
}
