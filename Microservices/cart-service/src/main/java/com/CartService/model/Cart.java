package com.CartService.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private int userId;
    private int productId;
    private int quantity;

    // Constructors, getters, and setters
    public Cart(){}
    public Cart(int cartId, int productId, int userId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }
    public int getCartId() {return cartId;}
    public void setCartId(int cartId) {this.cartId = cartId;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public int getUserId() {return userId;}
    public void setUserId(int userId) {this.userId = userId;}

    public int getProductId() {return productId;}

    public void setProductId(int productId) {this.productId = productId;}
}
