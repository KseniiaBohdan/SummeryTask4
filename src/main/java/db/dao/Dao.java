package db.dao;

import db.dbConnection.ConnectionPool;

import java.sql.Connection;
import java.util.List;

public interface Dao<Entity> {

    boolean update(Connection con, Entity entity);

    boolean create(Connection con, Entity entity);

    List<Entity> getAll(Connection con);

    boolean deleteAll(Connection con);
}
