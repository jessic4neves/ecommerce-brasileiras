package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.TrackDelivery;
import java.util.List;

public interface TrackDeliveryService {
    List<TrackDelivery> findAll();
    TrackDelivery findById(Long id);
    TrackDelivery save(TrackDelivery trackDelivery);
    void update(Long accountReceiveId, TrackDelivery trackDelivery);
    void delete(Long id);
}
