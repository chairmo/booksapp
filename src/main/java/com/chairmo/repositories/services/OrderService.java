package com.chairmo.repositories.services;

import com.chairmo.model.Customer;
import com.chairmo.model.Order;
import com.chairmo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order save(Order order);
    List<Order> findAll();
    Optional<Order> findById(Integer id);
    void deleteById(Integer id);

    //Using Page and pageable
    Page<Order> findOrderByCustomer(Customer customer, Pageable pageable);
    Page<Order> findAll(Pageable pageable);
}
