package com.brasileiras.controller;

import com.brasileiras.model.DeliveryEvent;
import com.brasileiras.service.DeliveryEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery-event")
public class DeliveryEventController {
    private final DeliveryEventService deliveryEventService;

    public DeliveryEventController(DeliveryEventService deliveryEventService) {
        this.deliveryEventService = deliveryEventService;
    }

    @GetMapping
    public List<DeliveryEvent> getAll() {
        return deliveryEventService.getAll();
    }

    @GetMapping("/{id}")
    public DeliveryEvent getById(@PathVariable Long id) {
        return deliveryEventService.getById(id);
    }

    @PostMapping
    public DeliveryEvent save(@RequestBody DeliveryEvent deliveryEvent) {
        return deliveryEventService.save(deliveryEvent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deliveryEventService.delete(id);
    }
}
