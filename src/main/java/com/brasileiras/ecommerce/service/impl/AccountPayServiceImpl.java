package com.brasileiras.service.impl;

import com.brasileiras.model.AccountPay;
import com.brasileiras.repository.AccountPayRepository;
import com.brasileiras.service.AccountPayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        AccountPay accountPay = findById(accountPayId);
        accountPayRepository.save(accountPay);
    }

    @Override
    public void delete(Long id) {
        accountPayRepository.deleteById(id);
    }
}
