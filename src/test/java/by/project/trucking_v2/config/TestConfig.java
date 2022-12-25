package by.project.trucking_v2.config;

import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.UserRepository;
import by.project.trucking_v2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@TestConfiguration
public class TestConfig {

    @Repository
    public interface TestUserRepository extends UserRepository{
    }

    @Service
    public static class TestUserService extends UserService {
        public TestUserService(TestUserRepository repo) {
            super(repo);
        }
        public User getUserById(Long id) {
            return super.getUserById(id);
        }
    }


}
