package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.User;
import by.project.trucking_v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRESTController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getById(id);
    }

    @GetMapping("/create")
    public User create(User user) {
        return userService.save(user);
    }
    @GetMapping("/update/{id}")
    public User updateUser(@PathVariable("id") int id) {
        return userService.update(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }
}



