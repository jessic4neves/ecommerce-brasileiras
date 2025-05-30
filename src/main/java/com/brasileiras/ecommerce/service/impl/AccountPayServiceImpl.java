package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.AccountPay;
import com.brasileiras.ecommerce.repository.AccountPayRepository;
import com.brasileiras.ecommerce.service.AccountPayService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountPayServiceImpl implements AccountPayService {
    private final AccountPayRepository accountPayRepository;

    public AccountPayServiceImpl(AccountPayRepository accountPayRepository) {
        this.accountPayRepository = accountPayRepository;
    }

    @Override
    public List<AccountPay> findAll() {
        return accountPayRepository.findAll();
    }

    @Override
    public AccountPay findById(Long id) {
        return accountPayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AccountPay not found"));
    }

    @Override
    public AccountPay save(AccountPay accountPay) {
        return accountPayRepository.save(accountPay);
    }

    @Override
    public void update(Long accountPayId, AccountPay accountPay) {
        AccountPay existingAccountPay = findById(accountPayId);
        existingAccountPay.setInvoicing(accountPay.getInvoicing());
        existingAccountPay.setValue(accountPay.getValue());
        existingAccountPay.setExpirationDate(accountPay.getExpirationDate());
        existingAccountPay.setPaymentDay(accountPay.getPaymentDay());
        existingAccountPay.setStatus(accountPay.getStatus());
        accountPayRepository.save(existingAccountPay);
    }

    @Override
    public void delete(Long id) {
        accountPayRepository.deleteById(id);
    }
}
