package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void save(User user);

    void update(int id, User updateuser);

    void delete(int id);
}
