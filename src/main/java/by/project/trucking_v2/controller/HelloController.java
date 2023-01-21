package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.User;
import by.project.trucking_v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {
    @Autowired
    UserService userService;


    @GetMapping(path = "/")
    public String index(Model model) {
        /*это для отображения пользователя в шапке страницы*/
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("login", login);
        return "index";
    }

    @GetMapping("/users/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "user_create";
    }

    @PostMapping("/users/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        //!Потом     вместо /login - ссылка на продолжение регистрации, где нужно будет ввести эл почту, название организации, УНП и телефон
        return "redirect:/login";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.toString();
    }

}
