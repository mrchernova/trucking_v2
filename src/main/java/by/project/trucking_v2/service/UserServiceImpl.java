package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByOrderById();
    }

    @Override
    public User getById(int id) {
        User user = userRepository.getUserById(id);
        if (user == null) {
            throw new NotFoundException(id);
        }
        return user;
    }

    @Override
    public User save(User user)  {
        user = new User();
        return userRepository.save(user);
    }

    @Override
    public User update(int id) {
        User u = userRepository.findById(id).orElseThrow();
        u.setLogin(new User().getLogin());
        u.setPassword(new User().getPassword());
        u.setRole(new User().getRole());

        return userRepository.save(u);
    }

    @Override
    public void delete(int id)  {
        userRepository.deleteById(id);
    }

}