package service;

import data.entity.Card;

import java.util.List;

public interface Service <Entity> {
    public boolean update(Entity entity);

    public boolean create(Entity entity);

    public List<Entity> getAll();

    public boolean deleteAll();

    boolean update(List<Entity> entity);
}
