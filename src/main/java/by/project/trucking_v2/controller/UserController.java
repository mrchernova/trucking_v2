package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.model.User;
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
@PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @PreAuthorize("hasAuthority('ADMINISTRATOR') or authentication.principal.id.equals(#id)")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(User user) {
        return  userService.save(user);
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR') or authentication.principal.login.equals(#user.login)")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, User user, LegalEntity legalEntity) {
        return userService.update(id, user, legalEntity);
    }

    @PreAuthorize("hasRole('ADMINISTRATOR') or authentication.principal.id.equals(#id)")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.delete(id);
    }

}

