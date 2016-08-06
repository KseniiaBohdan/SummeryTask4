package dao;

import entity.Entity;

import java.util.List;

public interface Dao {
    public boolean update(Entity entity);

    public boolean create(Entity entity);

    public Entity getById(Integer id);

    public List<Entity> getAll();

    public boolean deleteById(Integer id);

    public boolean deleteAll();
}
