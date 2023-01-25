package by.project.trucking_v2.service;

import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import by.project.trucking_v2.security.MyCustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User myUser = userRepository.findByLogin(login);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + login);
        }
        MyCustomUserDetails ud = MyCustomUserDetails.builder()
                .id(myUser.getId())
                .login(myUser.getLogin())
                .password(myUser.getPassword())
                .role(myUser.getRole().name())
                .build();
        return ud;
    }
}

