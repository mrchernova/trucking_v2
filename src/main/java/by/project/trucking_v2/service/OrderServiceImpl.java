/**
package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.AccessDeniedException;
import by.project.trucking_v2.exception.EmptyResultException;
import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.*;
import by.project.trucking_v2.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private LegalEntityRepository legalEntityRepository;
    @Autowired
    private CompletedOrderServiceImpl completedOrderService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Order> getAll() {
        Iterable<Order> iterable = orderRepository.findAll();
        List<Order> orders = Streamable.of(iterable).toList();
        return orders;
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }
    @Transactional
    @Override
    public Order save(Order order) {
        // проверка на наличие юр.лица
        if (legalEntityRepository.existsById(order.getLegalEntity().getId())) {

            // проверка роли
            User u = userRepository.findByLegalEntityId(order.getLegalEntity().getId()); //нах юзера по легал энтити айди
            if (u.getRole() == Role.CLIENT) {
                log.info("Заказ успешно сохранен");
                return orderRepository.save(order);
            } else {
                log.warn("Заказ НЕ сохранен. Вы должны быть зарегистрированы как клиент");
                throw new AccessDeniedException();
            }
        } else {
            log.warn("Заказ НЕ сохранен. Юр.лицо с id='" + order.getLegalEntity().getId() + "' не найдено");
            throw new NotFoundException();
        }
    }

    @Transactional
    @Override
    public Order update(Integer id, Order order) {
        Order currentOrder = orderRepository.findById(id).orElseThrow(NotFoundException::new);
        currentOrder.setDescription(order.getDescription());
        currentOrder.setWeight(order.getWeight());
        currentOrder.setDeparture(order.getDeparture());
        currentOrder.setDestination(order.getDestination());
        currentOrder.setPrice(order.getPrice());
        currentOrder.setStatus(order.getStatus());

           return orderRepository.save(currentOrder);
       }
    @Transactional
    @Override
    public void delete(Integer id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            log.info("Заказ успешно удален");
        } else {
            log.warn("Заказ НЕ удален. Заказа с id=" + id + " не существует");
            throw new EmptyResultException();
        }
    }
    @Transactional
    @Override
    public Order orderChoice(Integer id, Order order) {
        Order currentOrder = orderRepository.findById(id).orElseThrow(NotFoundException::new);
        if (currentOrder.getStatus() == Status.AVALIABLE) {

            currentOrder.setStatus(Status.IN_PROGRESS);
            completedOrderService.orderInProgress(id); //вызывается метод заполнения таблицы completed orders

            return orderRepository.save(currentOrder);
        }else{
            log.warn("Заказ недоступен или уже выполняется");
            throw new AccessDeniedException();
        }
    }


}
 */