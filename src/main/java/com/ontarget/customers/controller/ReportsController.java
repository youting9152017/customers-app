package com.ontarget.customers.controller;

import com.ontarget.customers.model.Customer;
import com.ontarget.customers.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reports")
public class ReportsController {
    @Autowired
    private CustomersRepository customersRepository;

    @RequestMapping("sellers")
    public String topSellersReport(Map<String, Object> model) {
        List<Customer> sellersTop = customersRepository.findTopSellers(5);

        model.put("customers", sellersTop);

        return "reports/topSellers";
    }
}
