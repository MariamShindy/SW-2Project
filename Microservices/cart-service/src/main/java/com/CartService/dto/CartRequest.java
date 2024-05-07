package com.CartService.dto;

public class CartRequest {
    private int userId;
    private int productId;
    private int quantity;

    // Constructors, getters, and setters
    public CartRequest(){}
    public CartRequest(int productId, int userId, int quantity) {
        this.quantity = quantity;
        this.productId = productId;
        this.userId = userId;
    }
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public int getProductId() {return productId;}

    public void setProductId(int productId) {this.productId = productId;}
}
