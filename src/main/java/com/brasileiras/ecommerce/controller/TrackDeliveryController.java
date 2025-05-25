package com.brasileiras.controller;

import com.brasileiras.model.TrackDelivery;
import com.brasileiras.service.TrackDeliveryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/track-delivery")
public class TrackDeliveryController {
    private final TrackDeliveryService trackDeliveryService;

    public TrackDeliveryController(TrackDeliveryService trackDeliveryService) {
        this.trackDeliveryService = trackDeliveryService;
    }

    @GetMapping
    public List<TrackDelivery> getAll() {
        return trackDeliveryService.getAll();
    }

    @GetMapping("/{id}")
    public TrackDelivery getById(@PathVariable Long id) {
        return trackDeliveryService.getById(id);
    }

    @PostMapping
    public TrackDelivery save(@RequestBody TrackDelivery trackDelivery) {
        return trackDeliveryService.save(trackDelivery);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trackDeliveryService.delete(id);
    }
}
