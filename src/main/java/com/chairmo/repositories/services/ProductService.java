package com.chairmo.repositories.services;

import com.chairmo.model.Product;
import com.chairmo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Integer id);
    void deleteById(Integer id);

    //Using Page and pageable
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
}
