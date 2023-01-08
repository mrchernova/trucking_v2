package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.Transport;
import by.project.trucking_v2.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Transport getById(@PathVariable("id") int id) {
        return transportService.findById(id);
    }



    @PostMapping
    public Transport create(@RequestBody Transport transport, @RequestParam int le_id) {
        return transportService.save(transport, le_id);
    }


    @PutMapping("/{id}")
    public Transport update(@PathVariable("id") int id, @RequestBody Transport transport) {
        return transportService.update(id, transport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        transportService.delete(id);
    }

}
