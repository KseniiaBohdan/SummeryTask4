package dao.implementation;

import dao.PaymentDao;
import dbConnection.ConnectionPool;
import entity.Payment;
import entity.PaymentStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    private static final String GET_USER_SENDER_ID = "SELECT * FROM payment WHERE card_number_sender IN " +
            "(SELECT id FROM card WHERE user_id = ?)";

    public boolean update(Payment payment) {
        return false;
    }

    public boolean create(Payment payment) {
        return false;
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
        PreparedStatement ps = con.prepareStatement(GET_USER_SENDER_ID);
        ResultSet rs = ps.executeQuery();
        List paymentList = new ArrayList<Payment>();
        while (rs.next()){
            Payment payment = new Payment(rs.getLong("id"), rs.getDate("date"), rs.getLong("number"),
                    rs.getLong("card_number_receiver"), rs.getLong("card_number_sender"), rs.getString("title"),
                    rs.getInt("sum"), PaymentStatus.valueOf(rs.getString("status")));
            paymentList.add(payment);
        }
        rs.close();
        ps.close();
        con.close();
        return paymentList;
    }
}
