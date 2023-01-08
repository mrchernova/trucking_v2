package by.project.trucking_v2.controller;

import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.service.LegalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/legalentity")
public class LegalEntityController {
    @Autowired
    private LegalEntityService legalEntityService;

    @GetMapping
    public List<LegalEntity> getAll() {
        return legalEntityService.getAll();
    }

    @GetMapping("/{id}")
    public LegalEntity getById(@PathVariable("id") int id) {
        return legalEntityService.findById(id);
    }

    @PostMapping
    public LegalEntity create(@RequestBody LegalEntity legalEntity) {
        return legalEntityService.save(legalEntity);
    }

    @PutMapping("/{id}")
    public LegalEntity update(@PathVariable("id") int id, @RequestBody LegalEntity legalEntity) {
        return legalEntityService.update(id, legalEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        legalEntityService.delete(id);
    }

}
