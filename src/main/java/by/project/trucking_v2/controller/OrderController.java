package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Order;
import by.project.trucking_v2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('CLIENT')")
    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PreAuthorize("hasAnyAuthority('CLIENT', 'ADMINISTRATOR')")
    @PutMapping("/{id}")
    public Order update(@PathVariable Integer id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @PreAuthorize("hasAnyAuthority('CLIENT', 'ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        orderService.delete(id);
    }


    //     * Обрабатывает событие, когда Перевозчик выберет заказ
//     * Статус заказа изменится на IN_PROGRESS
    @PreAuthorize("hasAuthority('CARRIER')")
    @PutMapping("/deal/{id}")
    public Order orderChoice(@PathVariable Integer id, @RequestBody Order order) {
        return orderService.orderChoice(id, order);
    }

}