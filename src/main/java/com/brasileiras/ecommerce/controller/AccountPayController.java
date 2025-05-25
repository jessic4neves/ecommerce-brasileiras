package com.brasileiras.ecommerce.controller;

import com.brasileiras.ecommerce.model.AccountPay;
import com.brasileiras.ecommerce.service.AccountPayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-pays")
public class AccountPayController {
    private final AccountPayService accountPayService;

    public AccountPayController(AccountPayService accountPayService) {
        this.accountPayService = accountPayService;
    }

    @GetMapping
    public List<AccountPay> getAll() {
        return accountPayService.findAll();
    }

    @GetMapping("/{id}")
    public AccountPay getById(@PathVariable Long id) {
        return accountPayService.findById(id);
    }

    @PutMapping
    public void update(@PathVariable Long id, @RequestBody AccountPay accountPay) {
        accountPayService.update(id, accountPay);
    }

    @PostMapping
    public AccountPay save(@RequestBody AccountPay accountPay) {
        return accountPayService.save(accountPay);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountPayService.delete(id);
    }
}
