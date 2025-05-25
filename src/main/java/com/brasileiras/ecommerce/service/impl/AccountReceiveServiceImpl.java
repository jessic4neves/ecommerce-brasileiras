package com.brasileiras.ecommerce.service.impl;

import com.brasileiras.ecommerce.model.AccountReceive;
import com.brasileiras.ecommerce.repository.AccountReceiveRepository;
import com.brasileiras.ecommerce.service.AccountReceiveService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountReceiveServiceImpl implements AccountReceiveService {
    private final AccountReceiveRepository accountReceiveRepository;

    public AccountReceiveServiceImpl(AccountReceiveRepository accountReceiveRepository) {
        this.accountReceiveRepository = accountReceiveRepository;
    }

    @Override
    public List<AccountReceive> findAll() {
        return accountReceiveRepository.findAll();
    }

    @Override
    public AccountReceive findById(Long id) {
        return accountReceiveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AccountReceive not found"));
    }

    @Override
    public AccountReceive save(AccountReceive accountReceive) {
        return accountReceiveRepository.save(accountReceive);
    }

    @Override
    public void update(Long accountReceiveId, AccountReceive updatedAccountReceive) {
        AccountReceive existingAccountReceive = findById(accountReceiveId);

        existingAccountReceive.setInvoicing(updatedAccountReceive.getInvoicing());
        existingAccountReceive.setValue(updatedAccountReceive.getValue());
        existingAccountReceive.setExpirationDate(updatedAccountReceive.getExpirationDate());
        existingAccountReceive.setPaymentDay(updatedAccountReceive.getPaymentDay());
        existingAccountReceive.setStatus(updatedAccountReceive.getStatus());

        accountReceiveRepository.save(existingAccountReceive);
    }

    @Override
    public void delete(Long id) {
        accountReceiveRepository.deleteById(id);
    }
}
