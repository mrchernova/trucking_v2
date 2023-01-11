package by.project.trucking_v2.service;

import by.project.trucking_v2.exception.NotFoundException;
import by.project.trucking_v2.model.CompletedOrder;
import by.project.trucking_v2.repository.CompletedOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletedOrderServiceImpl implements CompletedOrderService {
    @Autowired
    CompletedOrderRepository completedOrderRepository;

    @Override
    public List<CompletedOrder> getAll() {
        Iterable<CompletedOrder> iterable = completedOrderRepository.findAll();
        List<CompletedOrder> completedOrders = Streamable.of(iterable).toList();
        return completedOrders;
    }

    @Override
    public CompletedOrder findById(int id) {
        return completedOrderRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }


    @Override
    public CompletedOrder update(int id, CompletedOrder completedOrder) {
        CompletedOrder currentCompletedOrder = completedOrderRepository.findById(id).orElseThrow();
        currentCompletedOrder.setReport(completedOrder.getReport());

        /**
         *
         *      ????????????
         *
         */

        return completedOrderRepository.save(currentCompletedOrder);
    }

}