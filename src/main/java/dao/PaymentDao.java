package dao;

import entity.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDao extends Dao<Payment> {

    List getByUserSenderId(Long userId) throws SQLException;

    List getByUserReceiverId(Long userId) throws SQLException;
}
