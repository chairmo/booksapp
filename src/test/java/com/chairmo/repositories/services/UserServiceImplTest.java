package com.chairmo.repositories.services;

import com.chairmo.model.Address;
import com.chairmo.model.Customer;
import com.chairmo.model.User;
import org.junit.Before;
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
public class UserServiceImplTest {
    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    private UserService service;
    private User users;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        Customer customer = new Customer();
        customer.setEmail("jayjay@gmail.com");
        customer.setFirstName("james");
        customer.setLastName("jatau");
        customer.setPhoneNumber("09038499721");
        customer.setBillingAddress(new Address());
        customer.getBillingAddress().setCity("kuje");
        customer.getBillingAddress().setCountry("naija");
        customer.getBillingAddress().setState("abj");
        customer.updateTimeStamp();

        user.setUsername("jayboi");
        user.setPassword("jayjay");
        user.updateTimeStamp();
        user.setCustomer(customer);

        users = service.save(user);
    }

    @Test
    public void findAll() {
        List<User> user = service.findAll();

        assertEquals(1, user.size());
    }

    @Test
    public void findById() {
        List<User> users = service.findAll();

        assertEquals("jayboi", users.get(0).getUsername());
    }

    @Test
    public void deleteByUsername() {
        List<User> users = service.findAll();

       int i = service.deleteUserByUsername(users.get(0).getUsername());

        assertSame(1,i);
    }
}