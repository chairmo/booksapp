package com.chairmo.repositories;

import com.chairmo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //Using Page and pageable
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
}
