package com.brasileiras.service;

import com.brasileiras.model.AccountPay;
import java.util.List;

public interface AccountPayService {
    List<AccountPay> findAll();
    AccountPay findById(Long id);
    AccountPay save(AccountPay accountPay);
    void updateStock(Long accountPayId, int quantity);
    void delete(Long id);
}
