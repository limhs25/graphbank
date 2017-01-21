package com.bindstone.graphbank.provider;

import com.bindstone.graphbank.domain.Account;

public class AccountProvider {

    public static final Account POSITVE_ACCOUNT() {
        return Account
                .getBuilder("LU11222233334444")
                .value(10000)
                .build();
    }

    public static final Account NEGATIVE_ACCOUNT() {
        return Account
                .getBuilder("LU11222233334444")
                .value(-10000)
                .build();
    }

}
