package com.bindstone.graphbank.provider;

import com.bindstone.graphbank.domain.Currency;

public class CurrencyProvider {

    public static final Currency EURO() {
        Currency Currency = com.bindstone.graphbank.domain.Currency
                .getBuilder("Euro")
                .iso("EUR")
                .build();
        return Currency;
    }

    public static final Currency DOLLAR() {
        Currency Currency = com.bindstone.graphbank.domain.Currency
                .getBuilder("Dollar")
                .iso("USD")
                .build();
        return Currency;
    }
}
