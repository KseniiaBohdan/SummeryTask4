package db.dao;

import data.entity.Payment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface PaymentDao extends Dao<Payment> {

    List getByUserSenderId(Connection con, Long userId);

    List getByUserReceiverId(Connection con, Long userId);

    Payment getById(Connection con, Long id);
}
