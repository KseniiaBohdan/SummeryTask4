package dao.implementation;

import dao.CardDao;
import dbConnection.ConnectionPool;
import entity.Card;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CardDaoImpl implements CardDao {

    private static final String CREATE = "INSERT INTO card (card_number, user_id, expiry_date, pin, status, account_id, title)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?)";

    public boolean update(Card card) {
        return false;
    }

    public boolean create(Card card) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(CREATE);
        ps.setLong(1, card.getCardNumber());
        ps.setLong(2, card.getUserId());
        ps.setDate(3, (Date) card.getExpireDate());
        ps.setInt(4, card.getPin());
        ps.setString(5, card.getStatus().toString());
        ps.setLong(6, card.getAccountId());
        ps.setString(7, card.getTitle());
        ps.executeUpdate();
        ps.close();
        con.close();
        return true;
    }

    public Card getById(Long id) {
        return null;
    }

    public List<Card> getAll() {
        return null;
    }

    public boolean deleteById(Long id) {
        return false;
    }

    public boolean deleteAll() {
        return false;
    }
}
