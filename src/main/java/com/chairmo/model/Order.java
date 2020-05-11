package com.chairmo.model;

import com.chairmo.util.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Order extends AbstractObjectModel {
    @OneToOne
    private Customer customer;
    @Embedded
    private Address shipToAddress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date dateShipped;
    private OrderStatus orderStatus;

    public void addOrderDetails(OrderDetails orderDetail){
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }
    public void removeOrderDetails(OrderDetails orderDetail){
        orderDetail.setOrder(null);
        orderDetails.remove(orderDetail);
    }
}
