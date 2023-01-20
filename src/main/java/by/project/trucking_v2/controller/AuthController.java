package by.project.trucking_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/auth")
public class AuthController {

 //   @Autowired
  //  ActiveUserService activeUserService;

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/success")
    public  String getSuccessPage(){
        return "success";
    }

  //  @GetMapping(value = "/user")
   // public ModelAndView AllUserPage(){

      //  List<String> allActiveUsers = activeUserService.getAllActiveUsers();
     //   Iterable<User> users = allActiveUsers
    //            .stream().map(User::new).collect(Collectors.toList());
  //      return new ModelAndView("success", "user", users);
//    }

}