package com.oocode;

public class NumeralsClass {

    public int value;

    public NumeralsClass(int value) {
        this.value = value;
    }


    private String intToNumeral(int value){
        String numeral = "";

        if (value >= 40  && value < 50) {
            value = value - 40;
            numeral = numeral.concat(RomanNumerals.X.toString().concat(RomanNumerals.L.toString()));
        }

        while (value >= 10 && value < 40) {
            value = value - 10;
            numeral = numeral.concat(RomanNumerals.X.toString());
        }

        while (value == 9 ) {
            value = value - 9;
            numeral = numeral.concat(RomanNumerals.I.toString().concat(RomanNumerals.X.toString()));
        }

        while (value >= 5 && value < 9) {
            value = value - 5;
            numeral = numeral.concat(RomanNumerals.V.toString());
        }

        if( value == 0){
            return numeral;
        }

        while (value < 4) {
            value += RomanNumerals.I.value;
            numeral = numeral.concat(RomanNumerals.I.toString());
        }
        return numeral;

    }

    public String asString() {
        return intToNumeral(value);
    }
}
