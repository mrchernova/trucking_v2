package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController //контроллер, где каждый метод возвращает объект вместо представления(view)
public class IndexController {
    @Autowired
    private UserRepository userRepository;

//@RequestMapping("/getusers")
//public List<User> getUsers(){
//    return
//}


//    @RequestMapping("/saveuser") //не указывается GET, PUT, POST и т.д., потому то @RequestMapping сопоставляет все HTTP-операции
//    public User createUser() {
//        User u = new User();
//        try {
//            u = userRepository.save(new User("log", "pass", Role.CLIENT));
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("такой логин уже существует");
//        }
//        return u;
//    }

}



