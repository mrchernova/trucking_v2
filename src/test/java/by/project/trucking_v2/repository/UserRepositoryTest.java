package by.project.trucking_v2.repository;

import by.project.trucking_v2.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void get_by_id_should_return_nothing() {
        User byId = userRepository.findById(4L).orElse(null);
        assertNull(byId);
    }
}