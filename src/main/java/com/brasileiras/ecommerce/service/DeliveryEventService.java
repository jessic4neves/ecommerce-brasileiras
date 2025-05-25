package com.brasileiras.service;

import com.brasileiras.model.DeliveryEvent;
import java.util.List;

public interface DeliveryEventService {
    List<DeliveryEvent> findAll();
    DeliveryEvent findById(Long id);
    DeliveryEvent save(DeliveryEvent deliveryEvent);
    void updateStock(Long deliveryEventId, int quantity);
    void delete(Long id);
}
