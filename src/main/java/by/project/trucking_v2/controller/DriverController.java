package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Driver;
import by.project.trucking_v2.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping
    public List<Driver> getAll() {
        return driverService.getAll();
    }

    @GetMapping("/{id}")
    public Driver getById(@PathVariable("id") Integer id) {
        return driverService.findById(id);
    }

    @PreAuthorize("hasAuthority('CARRIER')")
    @PostMapping
    public Driver create(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @PreAuthorize("hasAnyAuthority('CARRIER', 'ADMINISTRATOR')")
    @PutMapping("/{id}")
    public Driver update(@PathVariable Integer id, @RequestBody Driver driver) {
        return driverService.update(id, driver);
    }
    @PreAuthorize("hasAnyAuthority('CARRIER', 'ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        driverService.delete(id);
    }

}
