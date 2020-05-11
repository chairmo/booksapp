package com.chairmo.repositories.services;


import com.chairmo.model.Customer;
import com.chairmo.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;



@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @TestConfiguration
    static class CustomerServiceImplContextConfig {

        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }

    @Autowired
    private CustomerService service;
    @MockBean
    private CustomerRepository repository;

    @Before
    public void setUp() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("james");
        customer.setLastName("jatau");

        Mockito.when(repository.findByLastName(customer.getFirstName()))
                .thenReturn(customer);
    }

    @Test
    public void findValidCustomer() {
        String name = "james";

        Customer customer = service.findByLastName(name);

        assertEquals("james", customer.getFirstName());
    }

}