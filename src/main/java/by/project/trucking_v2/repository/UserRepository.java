package by.project.trucking_v2.repository;

import by.project.trucking_v2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAllByOrderById();
    User findByLogin(String login);
    User findByLegalEntityId(Integer id);

}
