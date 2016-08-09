package service;

import entity.User;

public interface UserService extends Service<User> {

    public User getById(Long id);

    public boolean deleteById(Long id);

    public User getByEmail(String email) throws ClassNotFoundException;
}
