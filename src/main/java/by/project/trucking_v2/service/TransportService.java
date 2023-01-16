package by.project.trucking_v2.service;

import by.project.trucking_v2.model.Transport;

import java.util.List;

public interface TransportService {

    List<Transport> getAll();

    Transport findById(Integer id);

    Transport save(Transport transport);

    Transport update(Integer id, Transport transport);

    void delete(Integer id);

}
