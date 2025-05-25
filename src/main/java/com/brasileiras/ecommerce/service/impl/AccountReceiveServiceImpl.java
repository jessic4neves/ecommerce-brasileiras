package com.brasileiras.service.impl;

import com.brasileiras.model.AccountReceive;
import com.brasileiras.repository.AccountReceiveRepository;
import com.brasileiras.service.AccountReceiveService;
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
    public void update(Long accountReceiveId, AccountReceive accountReceive) {
        AccountReceive accountReceive = findById(accountReceiveId);
        accountReceiveRepository.save(accountReceive);
    }


    @Override
    public void delete(Long id) {
        accountReceiveRepository.deleteById(id);
    }
}
