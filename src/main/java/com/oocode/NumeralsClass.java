package com.oocode;

public class NumeralsClass {

    public int value;
    public String RomanNumeral;

    public NumeralsClass(int value) {
        this.value = value;
        this.RomanNumeral = intToNumeral(value);
    }

    private String intToNumeral(int value){

        return RomanNumerals.I.toString().concat(RomanNumerals.I.toString());
    }
}
