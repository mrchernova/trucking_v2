package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import by.project.trucking_v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(User user) {
        return  userService.save(user);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR') or principal.username == #user.login")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userService.update(id, user);
    }

//    @PreAuthorize("isFullyAuthenticated().")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println(userRepository.findById(id).get().getLogin());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//        userService.delete(id);
    }

}



