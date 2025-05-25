package com.brasileiras.controller;

import com.brasileiras.model.AccountReceive;
import com.brasileiras.service.AccountReceiveService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-receivces")
public class AccountReceiveController {
    private final AccountReceiveService accountReceiveService;

    public AccountReceiveController(AccountReceiveService accountReceiveService) {
        this.accountReceiveService = accountReceiveService;
    }

    @GetMapping
    public List<AccountReceive> getAll() {
        return accountReceiveService.getAll();
    }

    @GetMapping("/{id}")
    public AccountReceive getById(@PathVariable Long id) {
        return accountReceiveService.getById(id);
    }

    @PostMapping
    public AccountReceive save(@RequestBody AccountReceive accountReceive) {
        return accountReceiveService.save(accountReceive);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountReceiveService.delete(id);
    }
}
