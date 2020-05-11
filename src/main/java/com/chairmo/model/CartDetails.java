package com.chairmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class CartDetails extends AbstractObjectModel {

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

    private Integer quantity;
}
