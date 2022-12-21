package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import by.project.trucking_v2.service.DatasourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class indexController {
    @Autowired
    private UserRepository userRepository;
    DatasourceConfig datasourceConfig;

    @RequestMapping(value = "/create_user", method = RequestMethod.GET)
    public User createUser() {
//        datasourceConfig.setup();
        return userRepository.save(new User("log","pass", Role.CLIENT));

    }
}



