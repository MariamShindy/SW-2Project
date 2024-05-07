package com.orderService.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRequest {
private List<OrderItemsDto> orderItemsDtoList;
    private String shippingAddress;
    private Date orderDate;

    int userId ;
    public OrderRequest() {
        this.orderItemsDtoList = new ArrayList<>();
    }

    public OrderRequest(List<OrderItemsDto> orderItemsDtoList, String shippingAddress, Date orderDate, int userId) {
        this.orderItemsDtoList = orderItemsDtoList;
        this.shippingAddress = shippingAddress;
        this.orderDate = orderDate;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public List<OrderItemsDto> getOrderItemsDtoList() {
        return orderItemsDtoList;
    }

    public void setOrderItemsDtoList(List<OrderItemsDto> orderItemsDtoList) {
        this.orderItemsDtoList = orderItemsDtoList;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
