package com.itvedant.Customer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itvedant.Customer.entities.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer>{


List<Customer> findByCustomerName(String customername);
    @Query(value = "select * from customer order by customer_name",nativeQuery = true )
    List<Customer> sortByname();
}
