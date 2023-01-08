package by.project.trucking_v2.service;

import by.project.trucking_v2.model.Transport;

import java.util.List;

public interface TransportService {

    List<Transport> getAll();

    Transport findById(int id);

    Transport save(Transport transport, int le_id);

    Transport update(int id, Transport transport);

    void delete(int id);

}
