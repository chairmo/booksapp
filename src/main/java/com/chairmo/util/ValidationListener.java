package com.chairmo.util;

import com.chairmo.model.Customer;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class ValidationListener {
    @PrePersist
    @PreUpdate
    private void validate(Customer customer) {
        System.out.println(".ValidationListener validate()");

        if (customer.getFirstName() == null || "".equals(customer.getFirstName()))
            throw new IllegalArgumentException("Invalid first name");
        if (customer.getLastName() == null || "".equals(customer.getLastName()))
            throw new IllegalArgumentException("Invalid last name");
    }
}
