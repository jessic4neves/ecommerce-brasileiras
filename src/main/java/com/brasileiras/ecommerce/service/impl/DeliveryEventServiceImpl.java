package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.DeliveryEvent;
import com.brasileiras.ecommerce.repository.DeliveryEventRepository;
import com.brasileiras.ecommerce.service.DeliveryEventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeliveryEventServiceImpl implements DeliveryEventService {
    private final DeliveryEventRepository deliveryEventRepository;

    public DeliveryEventServiceImpl(DeliveryEventRepository deliveryEventRepository) {
        this.deliveryEventRepository = deliveryEventRepository;
    }

    @Override
    public List<DeliveryEvent> findAll() {
        return deliveryEventRepository.findAll();
    }

    @Override
    public DeliveryEvent findById(Long id) {
        return deliveryEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DeliveryEvent not found"));
    }

    @Override
    public DeliveryEvent save(DeliveryEvent deliveryEvent) {
        return deliveryEventRepository.save(deliveryEvent);
    }

    @Override
    public void update(Long deliveryEventId, DeliveryEvent deliveryEvent) {
        DeliveryEvent existingEvent = findById(deliveryEventId);
        existingEvent.setDateTime(deliveryEvent.getDateTime());
        existingEvent.setDescription(deliveryEvent.getDescription());
        existingEvent.setStatus(deliveryEvent.getStatus());
        deliveryEventRepository.save(existingEvent);
    }

    @Override
    public void delete(Long id) {
        deliveryEventRepository.deleteById(id);
    }
}
