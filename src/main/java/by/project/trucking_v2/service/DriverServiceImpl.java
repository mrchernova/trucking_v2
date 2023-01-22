package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.AccessDeniedException;
import by.project.trucking_v2.exception.DatabaseException;
import by.project.trucking_v2.exception.EmptyResultException;
import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.Driver;
import by.project.trucking_v2.model.LegalEntity;
import by.project.trucking_v2.model.Role;
import by.project.trucking_v2.model.User;
import by.project.trucking_v2.repository.DriverRepository;
import by.project.trucking_v2.repository.LegalEntityRepository;
import by.project.trucking_v2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    private static final Logger log = LoggerFactory.getLogger(DriverServiceImpl.class);
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private LegalEntityRepository legalEntityRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Driver> getAll() {
        Iterable<Driver> iterable = driverRepository.findAll();
        List<Driver> drivers = Streamable.of(iterable).toList();
        return drivers;
    }

    @Override
    public Driver findById(Integer id) {
        return driverRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }
    @Transactional
    @Override
    public Driver save(Driver driver) {
        // проверка на наличие юр.лица
        if (legalEntityRepository.existsById(driver.getLegalEntity().getId())) {

            // проверка роли
            User u = userRepository.findByLegalEntityId(driver.getLegalEntity().getId()); //нах юзера по легал энтити айди
            if (u.getRole() == Role.CARRIER) {
                log.info("Водитель успешно сохранен");
                return driverRepository.save(driver);
            } else {
                log.warn("Водитель НЕ сохранен. Вы должны быть зарегистрированы как перевозчик");
                throw new AccessDeniedException();
            }
        } else {
            log.warn("Водитель НЕ сохранен. Юр.лицо с id='" + driver.getLegalEntity().getId() + "' не найдено");
            throw new NotFoundException();
        }
    }

    @Transactional
    @Override
    public Driver update(Integer id, Driver driver) {
        Driver currentDriver = driverRepository.findById(id).orElseThrow(NotFoundException::new);
        currentDriver.setName(driver.getName());
        currentDriver.setSurname(driver.getSurname());
        currentDriver.setStatus(driver.getStatus());
        return driverRepository.save(currentDriver);
    }
    @Transactional
    @Override
    public void delete(Integer id) {
        if (driverRepository.existsById(id)) {
            driverRepository.deleteById(id);
            log.info("Водитель успешно удален");
        }else {
            log.warn("Водитель НЕ удален. Водителя с id=" + id + " не существует");
            throw new EmptyResultException();
        }
    }

}