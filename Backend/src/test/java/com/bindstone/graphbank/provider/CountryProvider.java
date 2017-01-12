package com.bindstone.graphbank.provider;

import com.bindstone.graphbank.domain.Country;

public class CountryProvider {

    public static final Country LUXEMBOURG() {
        Country country = Country
                .getBuilder("Luxembourg")
                .build();
        return country;
    }

    public static final Country ICELAND() {
        Country country = Country
                .getBuilder("Iceland")
                .build();
        return country;
    }
}
