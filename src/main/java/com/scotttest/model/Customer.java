package com.scotttest.model;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(\\S+)@(\\S+)\\.(\\S+)$", message = "Please provide a valid e-mail")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^^(\\d{1})\\((\\d{3})\\)(\\d{7})$$", message = "Please provide phone number in 1(123)1234567 format")
    @Column(nullable = false)
    private String phone;

    @Min(0)
    @NotNull
    @Column(nullable = false)
    private Long totalSales;

    public Customer() {
    }

    public Customer(String name, String email, String phone, Long totalSales) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.totalSales = totalSales;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Long totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) &&
                Objects.equals(name, customer.name) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(totalSales, customer.totalSales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, totalSales);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", totalSales=" + totalSales +
                '}';
    }
}
