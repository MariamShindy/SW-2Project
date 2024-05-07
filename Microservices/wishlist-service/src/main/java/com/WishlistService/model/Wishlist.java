package com.WishlistService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;
    private int userId;
    private int productId;

    public Wishlist() {}

    public Wishlist(int userId, int productId) {this.userId = userId; this.productId = productId;}

    // Getters and setters
    public int getWishlistId() {return wishlistId;}

    public void setWishlistId(int wishlistId) {this.wishlistId = wishlistId;}

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public int getProductId() {return productId;}

    public void setProductId(int productId) {this.productId = productId;}
}
