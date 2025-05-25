package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.AccountPay;
import java.util.List;

public interface AccountPayService {
    List<AccountPay> findAll();
    AccountPay findById(Long id);
    AccountPay save(AccountPay accountPay);
    void update(Long accountPayId, AccountPay accountPay);
    void delete(Long id);
}
