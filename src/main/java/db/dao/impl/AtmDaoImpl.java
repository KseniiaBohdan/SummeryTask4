package db.dao.impl;

import data.entity.Atm;
import db.dao.AtmDao;
import db.dbConstant.DbFieldConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtmDaoImpl implements AtmDao {

    private static final String CREATE = "INSERT INTO atm(card_number_receiver, sum) VALUES (?, ?)";
    private static final String GET_ALL = "SELECT * FROM atm";
    private static final String GET_BY_USER_ID = "SELECT * FROM atm WHERE card_number_receiver IN " +
            "(SELECT card_number FROM card WHERE user_id=?)";

    public boolean update(Connection con, Atm atm) {
        return false;
    }

    public boolean create(Connection con, Atm atm) {
        try {
            PreparedStatement ps = con.prepareStatement(CREATE);
            setPreparedStatement(atm, ps);
            int result = ps.executeUpdate();
            closeAll(ps);
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public List<Atm> getAll(Connection con) {
        List<Atm> atmList = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Atm atm = getAtm(rs);
                atmList.add(atm);
            }
            closeAll(ps, rs);
            return atmList;
        } catch (SQLException e) {
            return atmList;
        }
    }

    private Atm getAtm(ResultSet rs) throws SQLException {
        return new Atm(rs.getLong(DbFieldConstant.ID),
                rs.getLong(DbFieldConstant.CARD_NUMBER_RECEIVER),
                rs.getLong(DbFieldConstant.SUM));
    }

    public boolean deleteAll(Connection con) {
        return false;
    }

    private void setPreparedStatement(Atm atm, PreparedStatement ps) throws SQLException {
        ps.setLong(1, atm.getCardNumberReceiver());
        ps.setLong(2, atm.getSum());

    }

    public List<Atm> getByUserId(Connection con, Long userId) {
        List<Atm> atmList = new ArrayList();
        try {
            PreparedStatement ps = con.prepareStatement(GET_BY_USER_ID);
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Atm atm = new Atm(rs.getLong(DbFieldConstant.ID),
                        rs.getLong(DbFieldConstant.CARD_NUMBER_RECEIVER),
                        rs.getLong(DbFieldConstant.SUM));
                atmList.add(atm);
            }
            closeAll(ps, rs);
            return atmList;
        } catch (SQLException e) {
            return atmList;
        }
    }

    private void closeAll(PreparedStatement ps, ResultSet... rs) throws SQLException {
        for (int i = 0; i < rs.length; i++) {
            rs[i].close();
        }
        ps.close();
    }
}
