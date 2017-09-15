package com.scotttest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scotttest.service.CustomerService;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return this.customerService.getHelloMessage();
    }

    @RequestMapping("/add")
    void addCustomer(String strCustomer) {
        this.customerService.addCustomer(strCustomer);
    }

    @RequestMapping("/update")
    void updateCustomer(String strCustomer) {
        this.customerService.updateCustomer(strCustomer);
    }

    @RequestMapping("/delete")
    void deleteCustomer(Integer customerId) {
        this.customerService.deleteCustomer(customerId);
    }

    @RequestMapping("/report")
    @ResponseBody
    String report() {
        return this.customerService.getReport();
    }
}
