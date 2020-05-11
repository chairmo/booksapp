package com.chairmo.repositories.services;

import com.chairmo.model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("jpaDao")
public class ProductServiceImplTest {
    @Autowired
    public void setService(ProductService service) {
        this.service = service;
    }

    private ProductService service;

    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product();
        product.setDescription("food items");
        product.setPrice(BigDecimal.valueOf(29));
        product.setImageUrl("http://images_good");
        product.setName("semovita");
        product = service.save(product);
    }

    @Test
    public void findAll() {
        List<Product> products = service.findAll();
        assertEquals(1, products.size());
    }

    @Test
    public void findById() {
        assertEquals(BigDecimal.valueOf(29), product.getPrice());
        assertNotEquals("good food", product.getDescription());
        assertNotNull(product.getId());
    }

    @Test
    public void findByName() {

        assertEquals("semovita", product.getName());
    }

    @After
    public void tearDown() throws Exception {
        product = null;
    }
}