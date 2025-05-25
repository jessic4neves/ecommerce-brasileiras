package com.brasileiras.service;

import com.brasileiras.model.AccountReceive;
import java.util.List;

public interface AccountReceiveService {
    List<AccountReceive> findAll();
    AccountReceive findById(Long id);
    AccountReceive save(AccountReceive accountReceive);
    void updateStock(Long accountReceiveId, int quantity);
    void delete(Long id);
}
