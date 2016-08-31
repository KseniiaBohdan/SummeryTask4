package data.dao.impl;

import constant.dbConstant.DbFieldConstant;
import data.dao.CardRequestDao;
import data.entity.CardRequest;
import dbConnection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardRequestDaoImpl implements CardRequestDao {

    private static final String UPDATE = "";
    private static final String CREATE = "INSERT INTO card_request (card_number, title) VALUES (?, ?)";
    private static final String GET_ALL = "SELECT * FROM card_request";
    private static final String GET_BY_ID = "";
    private static final String DELETE_BY_CARD_ID = "DELETE FROM card_request WHERE card_number = ?";

    public boolean update(CardRequest cardRequest){
        return false;
    }

    public boolean create(CardRequest cardRequest){
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE);
            ps.setLong(1, cardRequest.getCardNumber());
            ps.setString(2, cardRequest.getTitle());
            int result = ps.executeUpdate();
            ps.close();
            con.close();
            return (result>0);
        } catch (SQLException e) {
            return false;
        }
    }

    public List<CardRequest> getAll(){
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            List<CardRequest> requests = new ArrayList();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                CardRequest cr = new CardRequest();
                cr.setId(rs.getLong(DbFieldConstant.ID));
                cr.setCardNumber(rs.getLong(DbFieldConstant.CARD_NUMBER));
                cr.setTitle(rs.getString(DbFieldConstant.TITLE));
                requests.add(cr);
            }
            rs.close();
            ps.close();
            con.close();
            return requests;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean deleteAll(){
        return false;
    }

    public boolean deleteByCardNumber(Long cardNumber) {
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DELETE_BY_CARD_ID);
            ps.setLong(1, cardNumber);
            int result = ps.executeUpdate();
            ps.close();
            con.close();
            return result>0;
        } catch (SQLException e) {
            return false;
        }
    }
}
