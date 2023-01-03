package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import by.project.trucking_v2.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

//@RestController //контроллер, где каждый метод возвращает объект вместо представления(view)
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/index")
    public String greeting(Model model) {
        model.addAttribute("title", "main page");
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
        Iterable<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/create")
    public String createUser(Model model) {         // если используются thymeleaf формы, то надо передавать объект для которого эта форма нужна
        model.addAttribute("user", new User());
        return "user_create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String userInfo(@PathVariable(value = "id") int userId, Model model) {
        if (!userRepository.existsById(userId)) {
            return "redirect:/error";
        }
        Optional<User> user = userRepository.findById(userId);
        ArrayList<User> u = new ArrayList<>();
        user.ifPresent(u::add); // из optional в arraylist
        model.addAttribute("user", u);
        return "user_info";
    }


    @GetMapping("/user/{id}/edit")
    public String userEdit(@PathVariable(value = "id") int id, Model model) {
        if (!userRepository.existsById(id)) {
            return "redirect:/error";
        }
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> u = new ArrayList<>();
        user.ifPresent(u::add);
        model.addAttribute("user", u);
        return "user_edit";
    }

    @PostMapping("/user/{id}/edit")
    public String userUpdate(@PathVariable(value = "id") int id,
                             @RequestParam String login,
                             @RequestParam String password,
                             @RequestParam Role role,
                             Model model
    ) {

        User u = userRepository.findById(id).orElseThrow();
        u.setLogin(login);
        u.setPassword(password);
        u.setRole(role);
        userRepository.save(u);
        return "redirect:/users";
    }


    @PostMapping("/user/{id}/delete")
    public String userDelete(@PathVariable(value = "id") int id, Model model) {
        User u = userRepository.findById(id).orElseThrow();
        userRepository.delete(u);
        return "redirect:/users";
    }




}



