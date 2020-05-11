package com.chairmo.controller;

import com.chairmo.model.Customer;
import com.chairmo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public List<?> getAllCustomers() {
        return customerService.listAll();
    }

    @PostMapping("/new")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveOrUpdate(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return id == null?new ResponseEntity<>(HttpStatus.NOT_FOUND):
                new ResponseEntity<>(customerService.saveOrUpdate(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
    }
}
