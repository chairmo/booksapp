package com.chairmo.model;

import com.chairmo.util.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "T_ORDER")
public class Order extends AbstractObjectModel {
    @Basic
    private LocalDateTime dateShipped;
    private OrderStatus orderStatus;

    @OneToOne
    private Customer customer;
    @Embedded
    private Address shipToAddress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<OrderDetails> orderDetails = new ArrayList<>();


    public void addOrderDetails(OrderDetails orderDetail){
        orderDetail.setOrder(this);
        orderDetails.add(orderDetail);
    }
    public void removeOrderDetails(OrderDetails orderDetail){
        orderDetail.setOrder(null);
        orderDetails.remove(orderDetail);
    }
}
