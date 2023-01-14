package by.project.trucking_v2.service;

import by.project.trucking_v2.model.CompletedOrder;
import by.project.trucking_v2.model.LegalEntity;

import java.util.List;

public interface CompletedOrderService {

    List<CompletedOrder> getAll();

    CompletedOrder findById(Integer id);

    CompletedOrder orderInProgress(Integer orderId);


}
