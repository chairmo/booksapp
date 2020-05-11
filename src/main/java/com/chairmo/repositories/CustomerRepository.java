package com.chairmo.repositories;

import com.chairmo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findByLastName(String lastName, Pageable pageable);
    Page<Customer> findAll(Pageable pageable);
    Customer findByLastName(String name);
}
