package data.dao.impl;

import constant.dbConstant.DbFieldConstant;
import data.dao.CardDao;
import dbConnection.ConnectionPool;
import data.entity.Card;
import data.entity.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CardDao {

    private static final String CREATE = "INSERT INTO card (card_number, user_id, expiry_date, pin, status_id, title, account_id )" +
            " VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_BY_USER_ID = "SELECT * FROM card WHERE user_id=?";
    private static final String GET_BY_ACCOUNT_ID = "SELECT * FROM card WHERE account_id=?";
    private static final String DELETE_BY_CARD_NUMBER = "UPDATE card SET status_id = 3 WHERE card_number = ?";
    private static final String GET_BY_ID = "SELECT * FROM card WHERE card_number=?";
    private static final String UPDATE = "UPDATE card SET user_id = ?, expiry_date = ?, pin = ?, status_id = ?, title = ? WHERE card_number = ?";
    private static final java.lang.String GET_NOT_DELETED_CARD_BY_USER_ID = "SELECT * FROM card WHERE user_id = ? AND status_id <> ?";
    private static final java.lang.String GET_ACTIVE_CARD_BY_USER_ID = "SELECT * FROM card WHERE user_id = ? AND status_id = ?";
    private static final String GET_BY_STATUS_ID = "SELECT * FROM card WHERE status_id = ? AND user_id = ?";

    public boolean update(Card card) {
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE);
            ps.setLong(1, card.getUserId());
            ps.setDate(2, card.getExpiryDate());
            ps.setInt(3, card.getPin());
            ps.setInt(4, card.getStatus().getId());
            ps.setString(5, card.getTitle());
            ps.setLong(6, card.getCardNumber());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean create(Card card) {
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE);
            ps.setLong(1, card.getCardNumber());
            ps.setLong(2, card.getUserId());
            ps.setDate(3, card.getExpiryDate());
            ps.setInt(4, card.getPin());
            ps.setInt(5, card.getStatus().getId());
            ps.setString(6, card.getTitle());
            ps.setLong(7, card.getAccountId());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Card getById(Long id) {
        Connection con = ConnectionPool.getConnection();
        Card card = null;
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                card = new Card();
                card = getCard(rs);
                rs.close();
                ps.close();
                con.close();
            }
            return card;
        } catch (SQLException e) {
            return card;
        }
    }

    private Card getCard(ResultSet rs) throws SQLException {
        Card card = new Card();
        card.setCardNumber(rs.getLong(DbFieldConstant.CARD_NUMBER));
        card.setUserId(rs.getLong(DbFieldConstant.USER_ID));
        card.setExpiryDate(rs.getDate(DbFieldConstant.EXPIRY_DATE));
        card.setPin(rs.getInt(DbFieldConstant.PIN));
        card.setStatus(rs.getInt(DbFieldConstant.STATUS_ID));
        card.setTitle(rs.getString(DbFieldConstant.TITLE));
        card.setAccountId(rs.getLong(DbFieldConstant.ACCOUNT_ID));
        return card;
    }

    public List<Card> getAll() {
        return null;
    }

    public boolean deleteByCardNumber(Long cardNumber) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement(DELETE_BY_CARD_NUMBER);
        ps.setLong(1, cardNumber);
        int result = ps.executeUpdate();
        ps.close();
        con.close();
        return (result > 0);
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
        while (rs.next()) {
            cardList.add(getCard(rs));
        }
        rs.close();
        ps.close();
        con.close();
        return cardList;
    }

    public List getByAccountId(Long accountId) {
        Connection con = ConnectionPool.getConnection();
        List cardList = new ArrayList<Card>();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_ACCOUNT_ID);
            ps.setLong(1, accountId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Card card = getCard(rs);
                cardList.add(card);
            }
            rs.close();
            ps.close();
            con.close();
            return cardList;
        } catch (SQLException e) {
            return cardList;
        }
    }

    public List<Card> getActiveByUserId(Long userId) {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(GET_ACTIVE_CARD_BY_USER_ID);
            ps.setLong(1, userId);
            ps.setInt(2, Status.ACTIVE.getId());
            ResultSet rs = ps.executeQuery();
            List cardList = new ArrayList<Card>();
            while (rs.next()) {
                cardList.add(getCard(rs));
            }
            rs.close();
            ps.close();
            con.close();
            return cardList;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean update(List<Card> cards) {
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(UPDATE);
            for(Card card : cards) {
                ps.setLong(1, card.getUserId());
                ps.setDate(2, card.getExpiryDate());
                ps.setInt(3, card.getPin());
                ps.setInt(4, card.getStatus().getId());
                ps.setString(5, card.getTitle());
                ps.setLong(6, card.getCardNumber());
                ps.executeUpdate();
            }
            ps.close();
            con.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public List getNotDeletedCardByUserId(Long userId) {
        Connection con = ConnectionPool.getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(GET_NOT_DELETED_CARD_BY_USER_ID);
            ps.setLong(1, userId);
            ps.setInt(2, Status.DELETED.getId());
            ResultSet rs = ps.executeQuery();
            List cardList = new ArrayList<Card>();
            while (rs.next()) {
                cardList.add(getCard(rs));
            }
            rs.close();
            ps.close();
            con.close();
            return cardList;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Card> getUsersCardByStatus(Status status, Long userId) {
        int statusId = status.getId();
        Connection con = ConnectionPool.getConnection();
        List<Card> cards = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_STATUS_ID);
            ps.setInt(1, statusId);
            ps.setLong(2, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                cards.add(getCard(rs));
            }
            rs.close();
            ps.close();
            con.close();
            return cards;
        } catch (SQLException e) {
            return cards;
        }
    }
}
