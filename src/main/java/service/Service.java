package service;

import entity.Entity;

import java.sql.SQLException;
import java.util.List;

public interface Service <Entity> {
    public boolean update(Entity entity) throws SQLException;

    public boolean create(Entity entity);

    public List<Entity> getAll();

    public boolean deleteAll();
}
