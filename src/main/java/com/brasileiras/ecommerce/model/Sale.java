public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNumber() {
    return number;
}

public void setNumber(String number) {
    this.number = number;
}

public LocalDateTime getDate() {
    return date;
}

public void setDate(LocalDateTime date) {
    this.date = date;
}

public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

public Address getDeliveryAddress() {
    return deliveryAddress;
}

public void setDeliveryAddress(Address deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
}

public List<SaleItem> getItems() {
    return items;
}

public void setItems(List<SaleItem> items) {
    this.items = items;
}

public List<Payment> getPayments() {
    return payments;
}

public void setPayments(List<Payment> payments) {
    this.payments = payments;
}

public List<AccountReceivable> getAccountsReceivable() {
    return accountsReceivable;
}

public void setAccountsReceivable(List<AccountReceivable> accountsReceivable) {
    this.accountsReceivable = accountsReceivable;
}

public DeliveryStatus getDeliveryStatus() {
    return deliveryStatus;
}

public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
}

public DeliveryTracking getTracking() {
    return tracking;
}

public void setTracking(DeliveryTracking tracking) {
    this.tracking = tracking;
}
