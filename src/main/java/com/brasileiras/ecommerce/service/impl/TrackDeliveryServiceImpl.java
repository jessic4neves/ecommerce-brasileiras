package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.TrackDelivery;
import com.brasileiras.ecommerce.repository.TrackDeliveryRepository;
import com.brasileiras.ecommerce.service.TrackDeliveryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackDeliveryServiceImpl implements TrackDeliveryService {
    private final TrackDeliveryRepository trackDeliveryRepository;

    public TrackDeliveryServiceImpl(TrackDeliveryRepository trackDeliveryRepository) {
        this.trackDeliveryRepository = trackDeliveryRepository;
    }

    @Override
    public List<TrackDelivery> findAll() {
        return trackDeliveryRepository.findAll();
    }

    @Override
    public TrackDelivery findById(Long id) {
        return trackDeliveryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TrackDelivery not found"));
    }

    @Override
    public TrackDelivery save(TrackDelivery trackDelivery) {
        return trackDeliveryRepository.save(trackDelivery);
    }

    @Override
    public void update(Long trackDeliveryId, TrackDelivery trackDelivery) {
        TrackDelivery existingTrackDelivery = findById(trackDeliveryId);
        
        existingTrackDelivery.setSale(trackDelivery.getSale());
        existingTrackDelivery.setTrackingCode(trackDelivery.getTrackingCode());
        existingTrackDelivery.setEvents(trackDelivery.getEvents());
        existingTrackDelivery.setDeliveryAttempts(trackDelivery.getDeliveryAttempts());
        
        trackDeliveryRepository.save(existingTrackDelivery);
    }

    @Override
    public void delete(Long id) {
        trackDeliveryRepository.deleteById(id);
    }
}
