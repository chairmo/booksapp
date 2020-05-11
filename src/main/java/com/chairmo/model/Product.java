package com.chairmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Product extends AbstractObjectModel {
    private String description;
    private BigDecimal price;
    private String imageUrl;
}
