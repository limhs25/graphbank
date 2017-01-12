package com.bindstone.graphbank.domain;

/**
 * Country Node Description
 */
public class Country extends AbstractNode {
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(name, country.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }

    public static class Builder {

        private Country built;

        public Builder(String name) {
            built = new Country();
            built.name = name;
        }

        public Country build() {
            return built;
        }

    }
}
