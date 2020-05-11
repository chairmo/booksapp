package com.chairmo.model;

import com.chairmo.util.ValidationListener;
import lombok.*;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@EntityListeners(ValidationListener.class)
public class Customer extends AbstractObjectModel {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Embedded
    private Address billingAddress;
    @Embedded
    private Address shippingAddress;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private User user;

    public Customer() {
    }

    public Customer(String john, String doe, String s, String s1) {
        this.firstName = john;
        this.lastName = doe;
        this.email = s;
        this.phoneNumber = s1;
    }
}
