package by.project.trucking_v2.service;

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
    public User findById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(int id, User user) {
        User currentUser = userRepository.findById(id).orElseThrow();

        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());
        currentUser.setRole(user.getRole());

        return userRepository.save(currentUser);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

}