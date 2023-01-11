package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Driver;
import by.project.trucking_v2.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<Driver> getAll() {
        return driverService.getAll();
    }

    @GetMapping("/{id}")
    public Driver getById(@PathVariable("id") int id) {
        return driverService.findById(id);
    }

    @PostMapping
    public Driver create(@RequestBody Driver driver, @RequestParam int le_id) {
        return driverService.save(driver, le_id);
    }

    @PutMapping("/{id}")
    public Driver update(@PathVariable("id") int id, @RequestBody Driver driver) {
        return driverService.update(id, driver);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        driverService.delete(id);
    }

}
