package com.bindstone.graphbank.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Currency Node Description
 */
public class Currency extends AbstractNode {
    private String name;
    private String iso;
    private String code;
    private int unit;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

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

    /**********************************************************************************
     * BUILDER
     */

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

        public Builder code(String code) {
            built.code = code;
            return this;
        }

        public Builder unit(int unit) {
            built.unit = unit;
            return this;
        }

        public Currency build() {
            return built;
        }

    }
}
