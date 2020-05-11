package com.chairmo.controller;

import com.chairmo.model.Product;
import com.chairmo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getUser(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public List<?> getAllUsers() {
        return productService.listAll();
    }

    @PostMapping("/new")
    public ResponseEntity<Product> createUser(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveOrUpdate(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateUser(@PathVariable Integer id, @RequestBody Product product) {
        return id == null?new ResponseEntity<>(HttpStatus.NOT_FOUND):
                new ResponseEntity<>(productService.saveOrUpdate(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        productService.delete(id);
    }
}
