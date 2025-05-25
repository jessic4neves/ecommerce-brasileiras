package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.DeliveryEvent;
import java.util.List;

public interface DeliveryEventService {
    List<DeliveryEvent> findAll();
    DeliveryEvent findById(Long id);
    DeliveryEvent save(DeliveryEvent deliveryEvent);
    void update(Long accountReceiveId, DeliveryEvent deliveryEvent);
    void delete(Long id);
}
