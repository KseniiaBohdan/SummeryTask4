package dao.implementation;

import dao.StatusDao;
import entity.Status;

import java.sql.SQLException;
import java.util.List;

public class StatusDaoImpl implements StatusDao {
    public boolean update(Status status) throws SQLException {
        return false;
    }

    public boolean create(Status status) throws SQLException {
        return false;
    }

    public List<Status> getAll() throws SQLException {
        return null;
    }

    public boolean deleteAll() throws SQLException {
        return false;
    }
}
