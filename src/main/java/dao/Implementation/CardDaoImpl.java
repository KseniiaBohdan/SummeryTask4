package dao.implementation;

import dao.CardDao;
import dbConnection.ConnectionPool;
import entity.BlockStatus;
import entity.Card;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CardDao {

    private static final String CREATE = "INSERT INTO card (card_number, user_id, expiry_date, pin, status, account_id, title)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_BY_USER_ID = "SELECT * FROM card WHERE user_id=?";
    private static final String GET_BY_ACCOUNT_ID = "SELECT * FROM card WHERE account_id=?";
    private static final String DELETE_BY_CARD_NUMBER = "DELETE FROM card WHERE card_number = ?";

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

    public boolean deleteByCardNumber(Long cardNumber) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(DELETE_BY_CARD_NUMBER);
        ps.setLong(1, cardNumber);
        ps.executeUpdate();
        ps.close();
        con.close();
        return  true;
    }

    public boolean deleteAll() {
        return false;
    }

    public List getByUserId(Long userId) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_USER_ID);
        ps.setLong(1, userId);
        ResultSet rs = ps.executeQuery();
        List cardList = new ArrayList<Card>();
        while (rs.next()){
            Card card = new Card(rs.getLong("card_number"), rs.getLong("user_id"), rs.getDate("expiry_date"),
            rs.getInt("pin"), BlockStatus.valueOf(rs.getString("status")), rs.getLong("account_id"), rs.getString("title"));
            cardList.add(card);
        }
        rs.close();
        ps.close();
        con.close();
        return cardList;
    }

    public List getByAccountId(Long accountId) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(GET_BY_ACCOUNT_ID);
        ps.setLong(1, accountId);
        ResultSet rs = ps.executeQuery();
        List cardList = new ArrayList<Card>();
        while (rs.next()){
            Card card = new Card(rs.getLong("card_number"), rs.getLong("user_id"), rs.getDate("expire_date"),
                    rs.getInt("pin"), BlockStatus.valueOf(rs.getString("status")), rs.getLong("account_id"), rs.getString("title"));
            cardList.add(card);
        }
        rs.close();
        ps.close();
        con.close();
        return cardList;
    }
}
