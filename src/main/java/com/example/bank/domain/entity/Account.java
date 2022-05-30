package com.example.bank.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "iban", length = 40)
    private String iban;
    @Column(name = "balance", length = 50)
    @Min(1000)
    @Max(500000)
    private Long balance;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Issuer issuer;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CardHolder cardHolder;

    public Account(String iban, long balance, Issuer issuer, CardHolder cardHolder) {
        this.iban = iban;
        this.balance = balance;
        this.issuer = issuer;
        this.cardHolder = cardHolder;
    }

    public Account() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}