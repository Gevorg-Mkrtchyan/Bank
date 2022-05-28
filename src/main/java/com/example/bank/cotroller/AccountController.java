package com.example.bank.cotroller;

import com.example.bank.domain.entity.Account;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts/{id}")
    public Account getById(@PathVariable("id") Long id) {
        return accountService.getByID(id);
    }

    @GetMapping("/accounts")
    public List<Account> getAll(Account account) {
        return accountService.getAll(account);
    }

    @PostMapping("/accounts")
    public Account create(@Valid @RequestBody Account account) {
        return accountService.create(account);
    }

    @PutMapping("/accounts")
    public Account update(@Valid @RequestBody Account account) {
        return accountService.update(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable("id") Long id) {
        accountService.delete(id);
    }
}
