package com.example.bank.domain.entity;

import com.example.bank.domain.enumType.CardStatus;
import com.example.bank.domain.enumType.CardType;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private CardType cardType;
    @Column(name = "balance", length = 25)
    @Min(0)
    @Max(value = 500000)
    private long balance;
    @Column(name = "card_number", unique = true, length = 16)
    @Pattern(regexp = "\\d{4}-\\d{4}-\\d{4}-\\d{4}")
    private String cardNumber;
    @JsonIgnore
    private Date exp = java.sql.Date.valueOf(LocalDate.now().plusYears(5).getYear() +
            "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth());
    @Column(name = "cvc", length = 25)
    private String cvc;
    @Column(name = "status", length = 25)
    private CardStatus status = CardStatus.CREATED;
    @Column(name = "pin", length = 4)
    private String pin;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Issuer issuer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CardHolder cardHolder;

    public Card(CardType cardType, long balance, String cardNumber, String cvc, String pin, Issuer issuer) {
        this.cardType = cardType;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.pin = pin;
        this.issuer = issuer;
    }

    public Card() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}

