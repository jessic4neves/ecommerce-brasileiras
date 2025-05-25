package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.Payment;
import com.brasileiras.ecommerce.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) {
        return paymentService.findById(id);
    }

    @PutMapping
    public Payment update(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.update(id, payment);
    }

    @PostMapping
    public Payment save(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
