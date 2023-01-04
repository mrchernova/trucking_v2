package by.project.trucking_v2.repository;

import by.project.trucking_v2.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAllByOrderById();

}
