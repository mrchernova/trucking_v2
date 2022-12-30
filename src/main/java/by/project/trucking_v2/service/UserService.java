package by.project.trucking_v2.service;

import by.project.trucking_v2.model.User;
import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(Integer id);
}
