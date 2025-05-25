package com.brasileiras.ecommerce.service;

import com.brasileiras.ecommerce.model.AccountReceive;
import java.util.List;

public interface AccountReceiveService {
    List<AccountReceive> findAll();
    AccountReceive findById(Long id);
    AccountReceive save(AccountReceive accountReceive);
    void update(Long accountReceiveId, AccountReceive accountReceive);
    void delete(Long id);
}
