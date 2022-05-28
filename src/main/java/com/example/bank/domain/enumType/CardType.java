package com.example.bank.domain.enumType;

public enum CardType {
    MASTERCARD(0),
    VISA(1),
    AMERICAN_EXPRESS(2);

    private final int i;

    CardType(int i) {
        this.i=i;
    }
}
