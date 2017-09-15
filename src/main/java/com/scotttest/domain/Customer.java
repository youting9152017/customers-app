package com.scotttest.domain;

public class Customer {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Integer totalSales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(name, customer.name)
                .append(email, customer.email)
                .append(phoneNumber, customer.phoneNumber)
                .append(totalSales, customer.totalSales)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(name)
                .append(email)
                .append(phoneNumber)
                .append(totalSales)
                .toHashCode();
    }
}
