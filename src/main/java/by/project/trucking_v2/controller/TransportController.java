package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Transport;
import by.project.trucking_v2.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {
    @Autowired
    private TransportService transportService;

    @GetMapping
    public List<Transport> getAll() {
        return transportService.getAll();
    }

    @GetMapping("/{id}")
    public Transport getById(@PathVariable Integer id) {
        return transportService.findById(id);
    }

    @PreAuthorize("hasAuthority('CARRIER')")
    @PostMapping
    public Transport create(@RequestBody Transport transport) {
        return transportService.save(transport);
    }

    @PreAuthorize("hasAnyAuthority('CARRIER', 'ADMINISTRATOR')")
    @PutMapping("/{id}")
    public Transport update(@PathVariable Integer id, @RequestBody Transport transport) {
        return transportService.update(id, transport);
    }

    @PreAuthorize("hasAnyAuthority('CARRIER', 'ADMINISTRATOR')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        transportService.delete(id);
    }

}