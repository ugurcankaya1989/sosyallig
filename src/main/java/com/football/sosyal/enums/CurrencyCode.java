package com.football.sosyal.enums;

public enum CurrencyCode {
    TR(1),
    EU(2),
    USD(3);

    private final int currencyCode;

    CurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }
}
