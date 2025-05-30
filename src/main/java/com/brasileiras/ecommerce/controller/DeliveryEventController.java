package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.DeliveryEvent;
import com.brasileiras.ecommerce.service.DeliveryEventService;
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
        return deliveryEventService.findAll();
    }

    @GetMapping("/{id}")
    public DeliveryEvent getById(@PathVariable Long id) {
        return deliveryEventService.findById(id);
    }

    @PutMapping
    public void update(@PathVariable Long id, @RequestBody DeliveryEvent deliveryEvent) {
        deliveryEventService.update(id, deliveryEvent);
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
