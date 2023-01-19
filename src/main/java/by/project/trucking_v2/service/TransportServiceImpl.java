/**
package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.AccessDeniedException;
import by.project.trucking_v2.exception.EmptyResultException;
import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.Transport;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.LegalEntityRepository;
import by.project.trucking_v2.repository.TransportRepository;
import by.project.trucking_v2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {
    private static final Logger log = LoggerFactory.getLogger(TransportServiceImpl.class);
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private LegalEntityRepository legalEntityRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Transport> getAll() {
        Iterable<Transport> iterable = transportRepository.findAll();
        List<Transport> transports = Streamable.of(iterable).toList();
        return transports;
    }

    @Override
    public Transport findById(Integer id) {
        return transportRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Transactional
    @Override
    public Transport save(Transport transport) {
        // проверка на наличие юр.лица
        if (legalEntityRepository.existsById(transport.getLegalEntity().getId())) {

            // проверка роли
            User u = userRepository.findByLegalEntityId(transport.getLegalEntity().getId()); //нах юзера по легал энтити айди
            if (u.getRole() == Role.CARRIER) {
                log.info("Транспортное средство успешно сохранено");
                return transportRepository.save(transport);
            } else {
                log.warn("транспортное средство НЕ сохранено. Вы должны быть зарегистрированы как перевозчик");
                throw new AccessDeniedException();
            }
        } else {
            log.warn("Транспортное средство НЕ сохранено. Юр.лицо с id='" + transport.getLegalEntity().getId() + "' не найдено");
            throw new NotFoundException();
        }

    }

    @Transactional
    @Override
    public Transport update(Integer id, Transport transport) {
        Transport currentTransport = transportRepository.findById(id).orElseThrow(NotFoundException::new);
        currentTransport.setModel(transport.getModel());
        currentTransport.setVehicleType(transport.getVehicleType());
        currentTransport.setCarryingCapacity(transport.getCarryingCapacity());
        currentTransport.setNumberPlate(transport.getNumberPlate());
        currentTransport.setStatus(transport.getStatus());
        return transportRepository.save(currentTransport);
    }
    @Transactional
    @Override
    public void delete(Integer id) {
        if (transportRepository.existsById(id)) {
            transportRepository.deleteById(id);
            log.info("Транспортное средство успешно удалено");
        } else {
            log.warn("Транспортное средство НЕ удалено. ТС с id=" + id + " не существует");
            throw new EmptyResultException();
        }
    }

}
 */