package com.bindstone.graphbank.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Account Node Description
 */
public class Account extends AbstractNode {
    private String iban;
    private double value;

    /**
     * BUILDER
     */
    public static Builder getBuilder(String name) {
        return new Builder(name);
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return new EqualsBuilder()
                .append(iban, account.iban)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(iban)
                .toHashCode();
    }

    public static class Builder {

        private Account built;

        public Builder(String iban) {
            built = new Account();
            built.iban = iban;
        }

        public Builder value(double value) {
            built.setValue(value);
            return this;
        }

        public Account build() {
            return built;
        }

    }
}
