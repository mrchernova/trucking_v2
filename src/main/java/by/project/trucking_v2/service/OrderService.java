package by.project.trucking_v2.service;

import by.project.trucking_v2.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Order findById(Integer id);

    Order save(Order order);

    Order update(Integer id, Order order);

    void delete(Integer id);


    Order orderChoice(Integer id, Order order);

}