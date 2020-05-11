package com.chairmo.repositories.services;

import com.chairmo.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("jpaDao")
public class OrderServiceImplTest {
    private OrderService orderService;
    @Autowired
    private void setOrderService(OrderService orderService){this.orderService = orderService;}

    @Test
    public void findAll() {
        List<Order> orders = orderService.findAll();

        assertEquals(2, orders.size());
        assertEquals("james", orders.get(0).getCustomer().getFirstName());
    }

    @Test
    public void findById() {
        List<Order> orders = orderService.findAll();

        assertNotNull(orders.get(0).getId());
        assertNotNull(orders.get(0).getCustomer().getId());
       // assertNotNull(orders.get(1).getCustomer().getVersion());
    }

    @Test
    public void deleteById() {
        orderService.deleteById(14);
        List<Order> orders = orderService.findAll();

        assertEquals(1, orders.size());
    }

}