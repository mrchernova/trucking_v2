package by.project.trucking_v2.service;

import by.project.trucking_v2.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User findById(int id);

    User save(User user);
    User update(int id, User user);
    void delete(int id);

}
