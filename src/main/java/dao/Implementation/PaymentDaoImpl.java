package dao.implementation;

import dao.PaymentDao;
import dbConnection.ConnectionPool;
import entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    private static final String GET_BY_USER_SENDER_ID = "SELECT * FROM payment WHERE card_number_sender IN " +
            "(SELECT id FROM card WHERE user_id = ?)";
    private static final String CREATE = "INSERT INTO payment(number, card_number_receiver, card_number_sender, title, sum, payment_status_id)" +
            "VALUES (?, ?, ?, ?, ?, ?)";
/*
    private static final String CREATE = "INSERT INTO payment(number, card_number_receiver, card_number_sender, title, sum, payment_status_id)" +
            "VALUES (23, 1111222233334444, 1111444477778888, 'qwe', 100, 1)";*/

    public boolean update(Payment payment) {
        return false;
    }

    public boolean create(Payment payment) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(CREATE);
        ps.setLong(1, payment.getNumber());
        ps.setLong(2, payment.getCardNumberReceiver());
        ps.setLong(3, payment.getGetCardNumberSender());
        ps.setString(4, payment.getTitle());
        ps.setInt(5, payment.getSum());
        ps.setInt(6, payment.getPaymentStatusId());
        int result = ps.executeUpdate();
        ps.close();
        con.close();
        return (result>0);
    }

    public Payment getById(Long id) {
        return null;
    }

    public List<Payment> getAll() {
        return null;
    }

    public boolean deleteById(Long id) {
        return false;
    }

    public boolean deleteAll() {
        return false;
    }

    public List getByUserSenderId(Long userId) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_USER_SENDER_ID);
        ps.setLong(1, userId);
        ResultSet rs = ps.executeQuery();
        List paymentList = new ArrayList<Payment>();
        while (rs.next()){
            Payment payment = new Payment(rs.getLong("id"), rs.getDate("date"), rs.getLong("number"),
                    rs.getLong("card_number_receiver"), rs.getLong("card_number_sender"), rs.getString("title"),
                    rs.getInt("sum"), rs.getInt("payment_status"));
            paymentList.add(payment);
        }
        rs.close();
        ps.close();
        con.close();
        return paymentList;
    }
}
