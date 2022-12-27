package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/create_user", method = RequestMethod.GET)
    public User createUser() {

        return userRepository.save(new User("log","pass", Role.CLIENT));

    }
}



