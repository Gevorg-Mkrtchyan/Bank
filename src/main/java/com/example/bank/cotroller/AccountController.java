package com.example.bank.cotroller;

import com.example.bank.domain.entity.Account;
import com.example.bank.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts/{id}")
    @ApiOperation("get account by id")
    public Account getById(@PathVariable("id") Long id) {
        return accountService.getByID(id);
    }

    @GetMapping("/accounts")
    @ApiOperation("get all accounts")
    public List<Account> getAll(Account account) {
        return accountService.getAll(account);
    }

    @PostMapping("/accounts")
    @ApiOperation("create account")
    public Account create(@Valid @RequestBody Account account) {
        return accountService.create(account);
    }

    @PutMapping("/accounts")
    @ApiOperation("update account")
    public Account update(@Valid @RequestBody Account account) {
        return accountService.update(account);
    }

    @DeleteMapping("/accounts/{id}")
    @ApiOperation("delete account by id")
    public void delete(@PathVariable("id") Long id) {
        accountService.delete(id);
    }
}
