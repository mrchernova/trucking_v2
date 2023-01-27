package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class MainController {
    @Autowired
    UserService userService;


    @GetMapping(path = "/")
    public String index(Model model) {
        /*это для отображения пользователя в шапке страницы*/
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("login", login);
        return "index";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/users/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "user_create";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user_create";
        } else {
            userService.save(user);
            return "/user_profile";
        }
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.toString();
    }

}
