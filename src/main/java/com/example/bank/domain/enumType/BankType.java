package com.example.bank.domain.enumType;

public enum BankType {
    CENTRAL(0),COMMERCIAL(1),SPECIALISED(2), COOPERATIVE(3);

    private final int i;
    BankType(int i){
        this.i=i;
    }

}
