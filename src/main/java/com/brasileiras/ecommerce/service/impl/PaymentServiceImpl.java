package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.Payment;
import com.brasileiras.ecommerce.repository.PaymentRepository;
import com.brasileiras.ecommerce.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void update(Long paymentId, Payment payment) {
        Payment payment = findById(paymentId);
        paymentRepository.save(payment);
    } 

    @Override
    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }
}
