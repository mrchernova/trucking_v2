package by.project.trucking_v2.config;

import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import by.project.trucking_v2.service.UserServiceImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@TestConfiguration
public class TestConfig {

    @Repository
    public interface TestUserRepository extends UserRepository{
    }

    @Service
    public static class TestUserServiceImpl extends UserServiceImpl {
        public TestUserServiceImpl(TestUserRepository repo) {
            super(repo);
        }
        public User getUserById(Integer id) {
            return super.getUserById(id);
        }
    }


}
