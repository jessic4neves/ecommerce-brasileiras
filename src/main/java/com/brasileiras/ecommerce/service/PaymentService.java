package com.brasileiras.service;

import com.brasileiras.model.Payment;
import java.util.List;

public interface PaymentService {
    List<Payment> findAll();
    Payment findById(Long id);
    Payment save(Payment payment);
    void update(Long accountReceiveId, Payment payment);
    void delete(Long id);
}
