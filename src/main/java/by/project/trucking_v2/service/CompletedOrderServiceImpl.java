/**
package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.*;
import by.project.trucking_v2.repository.CompletedOrderRepository;
import by.project.trucking_v2.repository.DriverRepository;
import by.project.trucking_v2.repository.OrderRepository;
import by.project.trucking_v2.repository.TransportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletedOrderServiceImpl implements CompletedOrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private CompletedOrderRepository completedOrderRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private TransportRepository transportRepository;

    @Override
    public List<CompletedOrder> getAll() {
        Iterable<CompletedOrder> iterable = completedOrderRepository.findAll();
        List<CompletedOrder> completedOrders = Streamable.of(iterable).toList();
        return completedOrders;
    }

    @Override
    public CompletedOrder findById(Integer id) {
        return completedOrderRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }



//     * Вызывается после выбора Заказа Перевозчиком
//     * Перевозчик сам определяет какого Водителя и какую Машину назначить для выполнения заказа
//     * следовательно передает driver_id и transport_id

    @Override
    public CompletedOrder orderInProgress(Integer orderId) {
        log.info("находим нужный заказ");
        Order currentOrder = orderRepository.findById(orderId).orElseThrow(NotFoundException::new);

        log.info("назначается водитель и транспорт для выполнения заказа");
//        это будет передаваться* через форму
        int id_driver = 1;
        int id_transport = 1;

        Driver thisDriver = driverRepository.findById(id_driver).orElseThrow(()->new RuntimeException("В базе нет водителя с таким id"));
        Transport thisTransport = transportRepository.findById(id_transport).orElseThrow(()->new RuntimeException("В базе нет машин с таким id"));

        log.info("заполняется таблица CompletedOrder");
        CompletedOrder newCompleteOrder = new CompletedOrder();
        newCompleteOrder.setOrder(currentOrder);
        newCompleteOrder.setDriver(thisDriver);
        newCompleteOrder.setTransport(thisTransport);
        newCompleteOrder.setReport(null);

        return completedOrderRepository.save(newCompleteOrder);
    }

}
 */