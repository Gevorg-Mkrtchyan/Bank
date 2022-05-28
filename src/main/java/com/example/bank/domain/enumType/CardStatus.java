package com.example.bank.domain.enumType;

public enum CardStatus {
    CREATED(0),
    ACTIVE(1),
    BLOCKED(2);

    private final int i;

    CardStatus(int i) {
        this.i = i;
    }
}
