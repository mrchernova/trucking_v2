package by.project.trucking_v2.service;

import by.project.trucking_v2.config.TestConfig;
import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestConfig.class })
public class UserServiceTest {

    @MockBean
    private TestConfig.TestUserRepository userRepository;
    private TestConfig.TestUserService service;

    @BeforeEach
    public void before() {
        service = new TestConfig.TestUserService(userRepository);
    }

    @Test
    public void services_test() {
        User userMock = new User(1, "login", "pass", Role.CLIENT);
        when(userRepository.findById(anyInt())).thenReturn(Optional.of(userMock));
        User found = service.getUserById(10000);

        Assertions.assertNotNull(found);
        Assertions.assertEquals(userMock, found);
    }


}