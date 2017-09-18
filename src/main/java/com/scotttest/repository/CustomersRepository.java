package com.scotttest.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.scotttest.model.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

    List<Customer> findAllByOrderByTotalSalesDesc(Pageable pageable);

    default List<Customer> findTopBySales(int numOfRecords) {
        return findAllByOrderByTotalSalesDesc(new PageRequest(0, numOfRecords));
    }
}
