package com.WishlistService.dto;

public class WishlistRequest {
    private int userId;
    private int productId;

    public WishlistRequest() {}

    public WishlistRequest(int userId, int productId) {this.userId = userId; this.productId = productId;}

    // Getters and setters
    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public int getProductId() {return productId;}

    public void setProductId(int productId) {this.productId = productId;}
}
