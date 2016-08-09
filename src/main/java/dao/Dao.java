package dao;

import entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface Dao<Entity> {
    public boolean update(Entity entity) throws SQLException;

    public boolean create(Entity entity) throws SQLException;

    public Entity getById(Long id) throws SQLException;

    public List<Entity> getAll() throws SQLException;

    public boolean deleteById(Long id) throws SQLException;

    public boolean deleteAll() throws SQLException;
}
