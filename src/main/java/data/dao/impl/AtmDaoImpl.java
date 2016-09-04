package data.dao.impl;

import constant.dbConstant.DbFieldConstant;
import data.dao.AtmDao;
import data.entity.Atm;
import dbConnection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtmDaoImpl implements AtmDao {

    private static final String CREATE = "INSERT INTO atm(card_number_receiver, sum) VALUES (?, ?)";
    private static final String GET_ALL = "SELECT * FROM atm";

    public boolean update(Atm atm) {
        return false;
    }

    public boolean create(Atm atm) {
        Connection con = ConnectionPool.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(CREATE);
            setPreparedStatement(atm, ps);
            int result = ps.executeUpdate();
            ps.close();
            con.close();
            return result>0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Atm> getAll() {
        Connection con = ConnectionPool.getConnection();
        List<Atm> atmList = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Atm atm = getAtm(rs);
                atmList.add(atm);
            }
            rs.close();
            ps.close();
            con.close();
            return atmList;
        } catch (SQLException e) {
            return atmList;
        }
    }

    private Atm getAtm(ResultSet rs) throws SQLException {
        return new Atm(rs.getLong(DbFieldConstant.ID), rs.getLong(DbFieldConstant.CARD_NUMBER_RECEIVER), rs.getLong(DbFieldConstant.SUM));
    }

    public boolean deleteAll() {
        return false;
    }

    private void setPreparedStatement(Atm atm, PreparedStatement ps) throws SQLException {
        ps.setLong(1, atm.getCardNumberReceiver());
        ps.setLong(2, atm.getSum());
    }
}
