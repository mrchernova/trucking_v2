package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.CompletedOrder;
import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.model.Order;
import by.project.trucking_v2.service.CompletedOrderService;
import by.project.trucking_v2.service.LegalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/completedorder")
public class CompletedOrderController {
    @Autowired
    private CompletedOrderService completedOrderService;

    @GetMapping
    public List<CompletedOrder> getAll() {
        return completedOrderService.getAll();
    }

    @GetMapping("/{id}")
    public CompletedOrder getById(@PathVariable("id") int id) {
        return completedOrderService.findById(id);
    }




}
