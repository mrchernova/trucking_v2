package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAllByOrderByIdDesc();
    }

    @Override
    public User getById(Integer id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new NotFoundException(id);
        }
        return user;
    }

//    @Override
//    public User getByLogin(String login) {
//        User user = userRepository.findByLogin(login);
//        if (user == null) {
//            throw new NotFoundException(login);
//        }
//        return user;
//    }


}