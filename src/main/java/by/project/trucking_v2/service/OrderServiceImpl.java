package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.*;
import by.project.trucking_v2.repository.CompletedOrderRepository;
import by.project.trucking_v2.repository.LegalEntityRepository;
import by.project.trucking_v2.repository.OrderRepository;
import by.project.trucking_v2.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    LegalEntityRepository legalEntityRepository;

    @Autowired
    CompletedOrderRepository completedOrderRepository;


    @Override
    public List<Order> getAll() {
        Iterable<Order> iterable = orderRepository.findAll();
        List<Order> orders = Streamable.of(iterable).toList();
        return orders;
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Order save(Order order, int le_id) {
        LegalEntity le = legalEntityRepository.findById(le_id).orElseThrow(NotFoundException::new);
        Order newOrder = new Order();
        newOrder.setDescription(order.getDescription());
        newOrder.setWeight(order.getWeight());
        newOrder.setDeparture(order.getDeparture());
        newOrder.setDestination(order.getDestination());
        newOrder.setPrice(order.getPrice());
        newOrder.setStatus(order.getStatus());
        newOrder.setLegalEntity(le);
        return orderRepository.save(newOrder);
    }


    @Override
    public Order update(int id, Order order) {
        Order currentOrder = orderRepository.findById(id).orElseThrow(NotFoundException::new);
        currentOrder.setDescription(order.getDescription());
        currentOrder.setWeight(order.getWeight());
        currentOrder.setDeparture(order.getDeparture());
        currentOrder.setDestination(order.getDestination());
        currentOrder.setPrice(order.getPrice());
        currentOrder.setStatus(order.getStatus());

        if (order.getStatus() == Status.SUCCESSFUL){
            CompletedOrder newCompletedOrder = new CompletedOrder();
            /**
             * надо как-то вызвать метод save с параметрами содержащими driver, transport, order
             *
             * в completedServiceImpl создать метод save
             * отсюда его вызвать
             * + если изменился статус, то и передавать надо транспорт и водителя еще
             */
        }
        return orderRepository.save(currentOrder);
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);
    }

}