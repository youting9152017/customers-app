package com.ontarget.customers.repository;

import com.ontarget.customers.model.Customer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
    List<Customer> findAllByOrderByTotalSalesDesc(Pageable pageable);

    default List<Customer> findTopSellers(int numOfRecords) {
        return findAllByOrderByTotalSalesDesc(new PageRequest(0, numOfRecords));
    }
}
