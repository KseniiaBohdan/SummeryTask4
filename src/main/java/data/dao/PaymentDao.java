package data.dao;

import data.entity.Payment;

import java.sql.SQLException;
import java.util.List;

public interface PaymentDao extends Dao<Payment> {

    List getByUserSenderId(Long userId);

    List getByUserReceiverId(Long userId) throws SQLException;
}
