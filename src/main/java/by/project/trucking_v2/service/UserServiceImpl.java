package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.DatabaseException;
import by.project.trucking_v2.exception.EmptyResultException;
import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.Status;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByOrderById();
    }

    @Override
    public User findById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return user;
    }

//    @Transactional
    @Override
    public User save(User user) {
        if (userRepository.findByLogin(user.getLogin()) == null) {
//            user.setStatus(Status.ACTIVE);                                                                              // security
//            user.setPassword(passwordEncoder.encode(user.getPassword()));                                               // security
            log.info("Пользователь успешно сохранен");
            return userRepository.save(user);
        } else {
            log.warn("Пользователь НЕ сохранен. Логин '" + user.getLogin() + "' уже существует");
            throw new DatabaseException();
        }

    }


    @Transactional
    @Override
    public User update(Integer id, User user) {
        User currentUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
        currentUser.setLogin(user.getLogin());
//        currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());
        currentUser.setRole(user.getRole());
//        currentUser.setStatus(user.getStatus());
        return userRepository.save(currentUser);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            log.info("Пользователь успешно удален");
        } else {
            log.warn("Пользователь НЕ удален. Пользователя с id=" + id + " не существует");
            throw new EmptyResultException();
        }
    }

}