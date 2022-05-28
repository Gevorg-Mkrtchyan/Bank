package com.example.bank.domain.entity;

import com.example.bank.domain.enumType.BankType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "issuer")
public class Issuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "bank_code")
    private String bankCode;
    @Column(name = "bank_name")
    @Min(3)
    private String bankName;
    @Enumerated(EnumType.ORDINAL)
    private BankType type;
    @OneToMany(mappedBy ="issuer",cascade = CascadeType.ALL)
    private Set<Card> cards;
    @OneToMany(mappedBy = "issuer")
    private Set<Account> accounts;

    public Issuer(String bankCode, String bankName, BankType type) {
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.type =type;
    }
    public Issuer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankType getType() {
        return type;
    }

    public void setType(BankType type) {
        this.type = type;
    }
}