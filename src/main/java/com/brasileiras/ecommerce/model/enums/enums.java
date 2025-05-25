package com.brasileiras.model.enums;

public enum PaymentMethod {
    CREDIT_CARD,
    DEBIT_CARD,
    BOLETO,
    PIX,
    INSTALLMENT
}

public enum AccountStatus {
    PENDING,
    PAID,
    OVERDUE,
    CANCELED
}

public enum DeliveryStatus {
    PROCESSING,
    SEPARATION,
    SHIPPING,
    DELIVERED,
    RETURNED
}

public enum DeliveryEventStatus {
    COLLECTED,
    IN_TRANSIT,
    DELIVERED,
    DELIVERY_FAILED,
    RETURNED
}
