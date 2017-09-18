package com.scotttest.controller;

import com.scotttest.model.Customer;
import com.scotttest.repository.CustomersRepository;
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

    @RequestMapping("sales")
    public String topSellersReport(Map<String, Object> model) {
        List<Customer> sellersTop = customersRepository.findTopBySales(5);

        model.put("customers", sellersTop);

        return "reports/topSales";
    }
}
