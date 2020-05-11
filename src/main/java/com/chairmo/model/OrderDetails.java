package com.chairmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class OrderDetails extends AbstractObjectModel{

    @ManyToOne
    private Order order;

    @OneToOne
    private Product product;

    private Integer quantity;
}
