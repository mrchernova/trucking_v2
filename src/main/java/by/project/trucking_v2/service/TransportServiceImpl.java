package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.model.Transport;
import by.project.trucking_v2.repository.LegalEntityRepository;
import by.project.trucking_v2.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {
    @Autowired
    TransportRepository transportRepository;
    @Autowired
    LegalEntityRepository legalEntityRepository;


    @Override
    public List<Transport> getAll() {
        Iterable<Transport> iterable = transportRepository.findAll();
        List<Transport> transports = Streamable.of(iterable).toList();
        return transports;
    }

    @Override
    public Transport findById(int id) {
        return transportRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Transport save(Transport transport, int le_id) {
        LegalEntity le = legalEntityRepository.findById(le_id).orElseThrow(NotFoundException::new);
        Transport newTransport = new Transport();
        newTransport.setModel(transport.getModel());
        newTransport.setVehicleType(transport.getVehicleType());
        newTransport.setCarryingCapacity(transport.getCarryingCapacity());
        newTransport.setNumberPlate(transport.getNumberPlate());
        newTransport.setStatus(transport.getStatus());
        newTransport.setLegalEntity(le);
        return transportRepository.save(newTransport);
    }


    @Override
    public Transport update(int id, Transport transport) {
        Transport currentTransport = transportRepository.findById(id).orElseThrow(NotFoundException::new);
        currentTransport.setModel(transport.getModel());
        currentTransport.setVehicleType(transport.getVehicleType());
        currentTransport.setCarryingCapacity(transport.getCarryingCapacity());
        currentTransport.setNumberPlate(transport.getNumberPlate());
        currentTransport.setStatus(transport.getStatus());
        return transportRepository.save(currentTransport);
    }

    @Override
    public void delete(int id) {
        transportRepository.deleteById(id);
    }

}