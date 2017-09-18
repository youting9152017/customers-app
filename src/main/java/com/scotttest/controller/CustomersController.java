package com.scotttest.controller;

import com.scotttest.model.Customer;
import com.scotttest.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping({"/customers", "/"})
public class CustomersController {

    @Autowired
    private CustomersRepository customersRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String showAllCustomers(Map<String, Object> model) {
        Iterable<Customer> customers = customersRepository.findAll();
        model.put("customers", customers);

        return "customers/all";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{customerId}")
    public String showCustomerDetails(Map<String, Object> model, @PathVariable Long customerId) {
        Customer customer = customersRepository.findOne(customerId);

        //TODO: null check -> error
        model.put("customer", customer);

        return "customers/customerDetails";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers/new")
    public String showNewCustomerForm(Map<String, Object> model) {
        model.put("customer", new Customer());

        return "customers/customerDetails";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/customers"})
    public String saveCustomer(@ModelAttribute Customer customer) {
        customersRepository.save(customer);
        return "redirect:/";
    }


}
