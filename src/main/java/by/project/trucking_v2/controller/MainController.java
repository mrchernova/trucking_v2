package by.project.trucking_v2.controller;

import by.project.trucking_v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "home";
    }


    @GetMapping("/index")
    public String getUsers() {
        userService.getAllUsers();
        return "index";

    }



}
