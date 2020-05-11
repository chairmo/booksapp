package com.chairmo.model;

import com.chairmo.util.ValidationListener;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

}
