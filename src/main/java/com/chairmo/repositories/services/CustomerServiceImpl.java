package com.chairmo.repositories.services;


import com.chairmo.model.Customer;
import com.chairmo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Profile("jpaDao")
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository repository;

    @Autowired
    private void setRepository(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.findById(id);
    }

    @Override
    public Page<Customer> findByLastName(String lastName, Pageable pageable) {
        return repository.findByLastName(lastName, pageable);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Customer findByLastName(String name) {
        return repository.findByLastName(name);
    }
}
