package com.scotttest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Value("${name:World}")
    private String name;

    public String getHelloMessage() {
        return "Hello " + this.name;
    }

    public void addCustomer(String strCustomer) {

    }

    public void updateCustomer(String strCustomer) {

    }

    public void deleteCustomer(Integer customerId) {

    }

    public String getReport() {
        return "Report";
    }
}
