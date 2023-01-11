package by.project.trucking_v2.service;

import by.project.trucking_v2.model.Driver;
import by.project.trucking_v2.model.Transport;

import java.util.List;

public interface DriverService {

    List<Driver> getAll();

    Driver findById(int id);

    Driver save(Driver driver, int le_id);

    Driver update(int id, Driver driver);

    void delete(int id);

}
