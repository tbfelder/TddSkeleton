package com.oocode;

public enum RomanNumerals {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    public final int value;

    private RomanNumerals(int value){
        this.value = value;
    }
}
