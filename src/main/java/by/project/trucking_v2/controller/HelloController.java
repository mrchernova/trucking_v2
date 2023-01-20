package by.project.trucking_v2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }


//    @GetMapping("/")
//    public String user(Authentication authentication) {
//        try {
//            System.out.println("это я вывожу из HelloController");
//            System.out.println("Текущий пользователь: " + (UserDetails) authentication.getPrincipal());
//            return "Текущий пользователь: " + (UserDetails) authentication.getPrincipal();
//        }catch(NullPointerException e){
//            return "index";
//        }
//    }

//    @GetMapping("/admin")
//
//    public String admin(Authentication authentication) {
//        System.out.println("это я вывожу из HelloController");
//        System.out.println((UserDetails)authentication.getPrincipal());
//        return "Admin";
//    }

}
