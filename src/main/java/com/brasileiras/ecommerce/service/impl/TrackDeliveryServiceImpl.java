package com.brasileiras.service.impl;

import com.brasileiras.model.TrackDelivery;
import com.brasileiras.repository.TrackDeliveryRepository;
import com.brasileiras.service.TrackDeliveryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        trackDelivery trackDelivery = findById(trackDeliveryId);
        trackDeliveryRepository.save(trackDelivery);
    } 

    @Override
    public void delete(Long id) {
        trackDeliveryRepository.deleteById(id);
    }
}
