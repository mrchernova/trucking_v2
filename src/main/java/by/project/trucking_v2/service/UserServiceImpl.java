package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByOrderById();
    }

    @Override
    public User findById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return user;
    }

    @Override
    public User save(User user) {
        User u = new User();
        try {
            u.setLogin(user.getLogin());
            log.info(ANSI_GREEN + "Пользователь успешно сохранен" + ANSI_RESET);
            return userRepository.save(user);
        } catch (Exception e){
            log.warn(ANSI_YELLOW + "Пользователь НЕ сохранен. Такой логин уже существует" + ANSI_RESET);
            return null;
        }
    }

    @Override
    public User update(int id, User user) {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException());

        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());
        currentUser.setRole(user.getRole());

        return userRepository.save(currentUser);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
        log.info(ANSI_GREEN + "Пользователь успешно удален" + ANSI_RESET);
    }

}