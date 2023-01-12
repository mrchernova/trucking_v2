package by.project.trucking_v2.service;

import by.project.trucking_v2.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Order findById(int id);

    Order save(Order order, int le_id);

    Order update(int id, Order order);

    void delete(int id);


    Order orderChoice(int id, Order order);

}
