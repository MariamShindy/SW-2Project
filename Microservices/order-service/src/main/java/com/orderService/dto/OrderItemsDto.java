package com.orderService.dto;

import java.math.BigDecimal;

public class OrderItemsDto {

    long id ;
    int selectedQuantity;
    BigDecimal subTotal;
    public OrderItemsDto(){

    }
    public OrderItemsDto(long id, int selectedQuantity, BigDecimal subTotal) {
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
