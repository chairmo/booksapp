package com.chairmo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Cart extends AbstractObjectModel {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
    private List<CartDetails> cartDetails = new ArrayList<>();

    @OneToOne
    private User user;

    public void addCartDetails(CartDetails cartDetail) {
        cartDetail.setCart(this);
        cartDetails.add(cartDetail);
    }
    public void removeCartDetails(CartDetails cartDetail){
        cartDetail.setCart(null);
        cartDetails.remove(cartDetail);
    }
}
