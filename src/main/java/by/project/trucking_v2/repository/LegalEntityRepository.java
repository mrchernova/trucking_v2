package by.project.trucking_v2.repository;

import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalEntityRepository extends CrudRepository<LegalEntity, Integer> {
    List<LegalEntity> findAllByOrderById();
}
