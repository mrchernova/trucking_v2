package by.project.trucking_v2.repository;

import by.project.trucking_v2.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
