package chingis.montayev.web.dao;


import chingis.montayev.web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUserById(Long id);

    public void add(User user);

    public void delete(Long id);

    public void update(User updatedUser);
}
