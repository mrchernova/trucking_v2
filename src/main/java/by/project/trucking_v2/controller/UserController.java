package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.User;
import by.project.trucking_v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;





import java.util.List;

@RestController //контроллер, где каждый метод возвращает объект вместо представления(view)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{userId:\\d+}")
    public User getUserById(@PathVariable("userId") Integer id) {
        return userService.getById(id);
    }

//    @GetMapping("/users/{userLogin:\\D+}")
//    public User getUserById(@PathVariable("userLogin") String login) {       //@PathVariable позволяет получать именованную часть урла и подставлять её как параметр метода.
//        return userService.getByLogin(login);
//    }

}



