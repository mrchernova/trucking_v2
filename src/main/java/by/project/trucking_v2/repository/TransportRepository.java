package by.project.trucking_v2.repository;

import by.project.trucking_v2.model.Transport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends CrudRepository<Transport, Integer> {
}