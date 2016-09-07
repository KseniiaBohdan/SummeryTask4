package data.dao.impl;

import constant.dbConstant.DbFieldConstant;
import data.dao.PaymentDao;
import data.entity.PaymentStatus;
import dbConnection.ConnectionPool;
import data.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    private static final String GET_BY_USER_SENDER_ID = "SELECT * FROM payment WHERE card_number_sender IN " +
            "(SELECT card_number FROM card WHERE user_id = ?)";
    private static final String GET_BY_USER_RECEIVER_ID = "SELECT * FROM payment WHERE card_number_receiver IN " +
            "(SELECT card_number FROM card WHERE user_id = ?)";
    private static final java.lang.String GET_ALL = "SELECT * FROM payment";
    private static final String CREATE = "INSERT INTO payment(number, card_number_receiver, card_number_sender, title, sum, payment_status_id)" +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT * FROM payment WHERE id = ?";
    private static final String UPDATE = "UPDATE payment SET payment_status_id = ?, date = ? WHERE id = ?";

    public boolean update(Payment payment) {
        Connection con = conPool.getFreeConnection();
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE);
            ps.setInt(1, payment.getPaymentStatus().getId());
            ps.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            ps.setLong(3, payment.getId());
            int result = ps.executeUpdate();
            closeAll(con, ps);
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean create(Payment payment) {
        Connection con = conPool.getFreeConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE);
            ps.setLong(1, payment.getNumber());
            ps.setLong(2, payment.getCardNumberReceiver());
            ps.setLong(3, payment.getCardNumberSender());
            ps.setString(4, payment.getTitle());
            ps.setInt(5, payment.getSum());
            ps.setInt(6, payment.getPaymentStatus().getId());
            int result = ps.executeUpdate();
            closeAll(con, ps);
            return (result > 0);
        } catch (SQLException e) {
            return false;
        }
    }

    public Payment getById(Long id) {
        Connection con = conPool.getFreeConnection();
        Payment payment = null;
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                payment = getPayment(rs);
            }
            closeAll(con, ps, rs);
            return payment;
        } catch (SQLException e) {
            return payment;
        }
    }

    public List<Payment> getAll() {
        Connection con = conPool.getFreeConnection();
        List paymentList = new ArrayList<Payment>();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paymentList.add(getPayment(rs));
            }
            closeAll(con, ps, rs);
            return paymentList;
        } catch (SQLException e) {
            return paymentList;
        }
    }

    public boolean deleteById(Long id) {
        return false;
    }

    public boolean deleteAll() {
        return false;
    }

    public List getByUserSenderId(Long userId) {
        Connection con = conPool.getFreeConnection();
        List paymentList = new ArrayList<Payment>();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_USER_SENDER_ID);
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paymentList.add(getPayment(rs));
            }
            closeAll(con, ps, rs);
            return paymentList;
        } catch (SQLException e) {
            return paymentList;
        }
    }

    public List<Payment> getByUserReceiverId(Long userId) {
        Connection con = conPool.getFreeConnection();
        List paymentList = new ArrayList<Payment>();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_USER_RECEIVER_ID);
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paymentList.add(getPayment(rs));
            }
            closeAll(con, ps, rs);
            return paymentList;
        } catch (SQLException e) {
            return paymentList;
        }
    }

    private Payment getPayment(ResultSet rs) throws SQLException {
        Payment payment = new Payment();
        payment.setId(rs.getLong(DbFieldConstant.ID));
        payment.setDate(rs.getDate(DbFieldConstant.DATE));
        payment.setNumber(rs.getLong(DbFieldConstant.NUMBER));
        payment.setCardNumberReceiver(rs.getLong(DbFieldConstant.CARD_NUMBER_RECEIVER));
        payment.setCardNumberSender(rs.getLong(DbFieldConstant.CARD_NUMBER_SENDER));
        payment.setTitle(rs.getString(DbFieldConstant.TITLE));
        payment.setSum(rs.getInt(DbFieldConstant.SUM));
        payment.setPaymentStatus(rs.getInt(DbFieldConstant.PAYMENT_STATUS_ID));
        return payment;
    }

    private void closeAll(Connection con, PreparedStatement ps, ResultSet... rs) throws SQLException {
        for (int i = 0; i < rs.length; i++) {
            rs[i].close();
        }
        ps.close();
        conPool.putUnusedConnection(con);
    }
}
