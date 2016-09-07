package data.dao;

import dbConnection.ConnectionPool;

import java.sql.SQLException;
import java.util.List;

public interface Dao<Entity> {

    boolean update(Entity entity);

    boolean create(Entity entity);

    List<Entity> getAll();

    boolean deleteAll();

    ConnectionPool conPool = new ConnectionPool();
}
