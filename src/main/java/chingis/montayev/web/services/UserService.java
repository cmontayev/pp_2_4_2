package chingis.montayev.web.services;

//В приложении должна быть страница,
//  - на которую выводятся все юзеры с возможностью
//  - добавлять,
//  - удалять
//  - изменять юзера.


import chingis.montayev.web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUserById(Long id);

    public void add(User user);

    public void delete(Long id);

    public void update( User updatedUser);
    User getByName(String name);

}
