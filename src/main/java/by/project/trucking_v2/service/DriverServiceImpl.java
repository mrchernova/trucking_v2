package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.Driver;
import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.repository.DriverRepository;
import by.project.trucking_v2.repository.LegalEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    LegalEntityRepository legalEntityRepository;


    @Override
    public List<Driver> getAll() {
        Iterable<Driver> iterable = driverRepository.findAll();
        List<Driver> drivers = Streamable.of(iterable).toList();
        return drivers;
    }

    @Override
    public Driver findById(int id) {
        return driverRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Driver save(Driver driver, int le_id) {
        LegalEntity le = legalEntityRepository.findById(le_id).orElseThrow(NotFoundException::new);
        Driver newDriver = new Driver();
        newDriver.setName(driver.getName());
        newDriver.setSurname(driver.getSurname());
        newDriver.setStatus(driver.getStatus());
        newDriver.setLegalEntity(le);
        return driverRepository.save(newDriver);
    }


    @Override
    public Driver update(int id, Driver driver) {
        Driver currentDriver = driverRepository.findById(id).orElseThrow(NotFoundException::new);
        currentDriver.setName(driver.getName());
        currentDriver.setSurname(driver.getSurname());
        currentDriver.setStatus(driver.getStatus());
        return driverRepository.save(currentDriver);
    }

    @Override
    public void delete(int id) {
        driverRepository.deleteById(id);
    }

}