package com.chairmo.repositories;

import com.chairmo.model.Customer;
import com.chairmo.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Page<Order> findOrderByCustomer(Customer customer, Pageable pageable);

    @Override
    Page<Order> findAll(Pageable pageable);
}
