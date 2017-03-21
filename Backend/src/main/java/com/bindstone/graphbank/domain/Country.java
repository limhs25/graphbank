package com.bindstone.graphbank.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Country Node Description
 */
public class Country extends AbstractNode {
    private String name;

    private Currency currency;

    public static Builder getBuilder(String name) {
        return new Builder(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Country country = (Country) o;

        return new EqualsBuilder()
                .append(name, country.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }

    /**********************************************************************************
     * BUILDER
     */

    public static class Builder {

        private Country built;

        public Builder(String name) {
            built = new Country();
            built.name = name;
        }

        public Builder currency(Currency currency) {
            built.currency = currency;
            return this;
        }

        public Country build() {
            return built;
        }

    }
}
