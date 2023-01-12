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
    public Order getById(@PathVariable("id") int id) {
        return orderService.findById(id);
    }

    @PostMapping
    public Order create(@RequestBody Order order, @RequestParam int le_id) {
        return orderService.save(order, le_id);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable("id") int id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        orderService.delete(id);
    }



    /**
     * Обрабатывает событие, когда Перевозчик выберет заказ
     * Статус заказа изменится на IN_PROGRESS
     * Сам Перевозчик будет сохранен в сессии (скоро, но пока не работает)
     */
    @PutMapping("/deal/{id}")
    public Order orderChoice(@PathVariable("id") int id, @RequestBody Order order) {
        return orderService.orderChoice(id, order);
    }

}
