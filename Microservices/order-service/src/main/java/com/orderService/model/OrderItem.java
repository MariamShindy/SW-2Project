package com.orderService.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id ;
    int selectedQuantity;
    BigDecimal subTotal;
    public OrderItem(){

    }

    public OrderItem(long id, int selectedQuantity, BigDecimal subTotal) {
        this.id = id;
        this.selectedQuantity = selectedQuantity;
        this.subTotal = subTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(int selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }
}
