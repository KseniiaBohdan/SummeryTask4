package dao;

import entity.Entity;

import java.util.List;

public class CardDao implements Dao {
    public boolean update(Entity entity) {
        return false;
    }

    public boolean create(Entity entity) {
        return false;
    }

    public Entity getById(Integer id) {
        return null;
    }

    public List<Entity> getAll() {
        return null;
    }

    public boolean deleteById(Integer id) {
        return false;
    }

    public boolean deleteAll() {
        return false;
    }
}
