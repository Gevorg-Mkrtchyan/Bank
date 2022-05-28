package com.example.bank.service;

import com.example.bank.domain.entity.Account;
import com.example.bank.domain.entity.Address;
import com.example.bank.domain.entity.CardHolder;
import com.example.bank.repository.AccountRepository;
import com.example.bank.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getByID(Long id) {
        return this.accountRepository.findById(id).get();
    }
    public List<Account> getAll(Account account){
        return this.accountRepository.findAll();
    }

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Account update(Account account) {
        return accountRepository.save(account);
    }

    public void delete(Long id) {
        accountRepository.delete(accountRepository.findById(id).get());
    }
}
