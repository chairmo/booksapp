package com.chairmo.repositories.services;

import com.chairmo.model.Product;
import com.chairmo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Profile("jpaDao")
public class ProductServiceImpl implements ProductService {

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    private ProductRepository repository;

    @Override
    @Transactional
    public Product save(Product product) {
        return repository.saveAndFlush(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return repository.findByName(name, pageable);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
