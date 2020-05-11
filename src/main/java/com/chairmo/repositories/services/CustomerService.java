package com.chairmo.repositories.services;

import com.chairmo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Integer id);
    void deleteById(Integer id);

    //Using Page and pageable
    Page<Customer> findByLastName(String lastName, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
    Customer findByLastName(String name);
}
