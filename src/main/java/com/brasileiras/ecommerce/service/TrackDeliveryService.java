package com.brasileiras.service;

import com.brasileiras.model.TrackDelivery;
import java.util.List;

public interface TrackDeliveryService {
    List<TrackDelivery> findAll();
    TrackDelivery findById(Long id);
    TrackDelivery save(TrackDelivery trackDelivery);
    void update(Long accountReceiveId, TrackDelivery trackDelivery);
    void delete(Long id);
}
