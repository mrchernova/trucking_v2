/**
package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Order;
import by.project.trucking_v2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Integer id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Integer id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.delete(id);
    }




//     * Обрабатывает событие, когда Перевозчик выберет заказ
//     * Статус заказа изменится на IN_PROGRESS

    @PutMapping("/deal/{id}")
    public Order orderChoice(@PathVariable Integer id, @RequestBody Order order) {
        return orderService.orderChoice(id, order);
    }

}
*/