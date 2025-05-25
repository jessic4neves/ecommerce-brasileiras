package com.brasileiras.service.impl;

import com.brasileiras.model.DeliveryEvent;
import com.brasileiras.repository.DeliveryEventRepository;
import com.brasileiras.service.DeliveryEventService;
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
    @Transactional
    public void updateStock(Long deliveryEventId, int quantity) {
        DeliveryEvent deliveryEvent = findById(deliveryEventId);
        deliveryEvent.setEstoque(deliveryEvent.getEstoque() + quantity);
        deliveryEventRepository.save(deliveryEvent);
    }

    @Override
    public void delete(Long id) {
        deliveryEventRepository.deleteById(id);
    }
}
