package db.dao.impl;

import data.entity.CardRequest;
import db.dao.CardRequestDao;
import db.dbConstant.DbFieldConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardRequestDaoImpl implements CardRequestDao {

    private static final String CREATE = "INSERT INTO card_request (card_number, title) VALUES (?, ?)";
    private static final String GET_ALL = "SELECT * FROM card_request";
    private static final String DELETE_BY_CARD_ID = "DELETE FROM card_request WHERE card_number = ?";

    public boolean update(Connection con, CardRequest cardRequest) {
        return false;
    }

    public boolean create(Connection con, CardRequest cardRequest) {
        try {
            PreparedStatement ps = con.prepareStatement(CREATE);
            ps.setLong(1, cardRequest.getCardNumber());
            ps.setString(2, cardRequest.getTitle());
            int result = ps.executeUpdate();
            closeAll(ps);
            return (result > 0);
        } catch (SQLException e) {
            return false;
        }
    }

    public List<CardRequest> getAll(Connection con) {
        List<CardRequest> requests = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CardRequest cr = new CardRequest();
                cr.setId(rs.getLong(DbFieldConstant.ID));
                cr.setCardNumber(rs.getLong(DbFieldConstant.CARD_NUMBER));
                cr.setTitle(rs.getString(DbFieldConstant.TITLE));
                requests.add(cr);
            }
            closeAll(ps, rs);
            return requests;
        } catch (SQLException e) {
            return requests;
        }
    }

    public boolean deleteAll(Connection con) {
        return false;
    }

    public boolean deleteByCardNumber(Connection con, Long cardNumber) {
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_BY_CARD_ID);
            ps.setLong(1, cardNumber);
            int result = ps.executeUpdate();
            closeAll(ps);
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    private void closeAll(PreparedStatement ps, ResultSet... rs) throws SQLException {
        for (int i = 0; i < rs.length; i++) {
            rs[i].close();
        }
        ps.close();
    }
}
