package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user) {
        User userDB = userRepository.findByLogin(user.getLogin());


        if (userDB != null) {
            System.out.println("message: User exists!");

            return "registration";
        }


//        user.setRole(Role.getByOrdinal(0));
        user.setRole(Role.ADMINISTRATOR);


        userRepository.save(user);

        return "redirect:/login";
    }



    @GetMapping("/create")
    public String createUser(Model model) {         // если используются thymeleaf формы, то надо передавать объект для которого эта форма нужна
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/index";
    }
}