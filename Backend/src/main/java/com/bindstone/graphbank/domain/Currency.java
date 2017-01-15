package com.bindstone.graphbank.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Currency Node Description
 */
public class Currency extends AbstractNode {
    private String name;
    private String iso;

    /**
     * BUILDER
     */
    public static Builder getBuilder(String name) {
        return new Builder(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        return new EqualsBuilder()
                .append(name, currency.name)
                .append(iso, currency.iso)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(iso)
                .toHashCode();
    }

    public static class Builder {

        private Currency built;

        public Builder(String name) {
            built = new Currency();
            built.name = name;
        }

        public Builder iso(String iso) {
            built.iso = iso;
            return this;
        }

        public Currency build() {
            return built;
        }

    }
}
