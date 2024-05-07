package com.CartService.controller;

import com.CartService.dto.CartRequest;
import com.CartService.model.Cart;
import com.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Cart>> getUserCart(@PathVariable int userId) {
        List<Cart> cart = cartService.getUserCart(userId);
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<Cart> addItemToCart(@RequestBody CartRequest cartItemRequest) {
        Cart addedItem = cartService.addItemToCart(cartItemRequest);
        return ResponseEntity.ok(addedItem);
    }

    @DeleteMapping("/remove/{userId}/{productId}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable int userId, @PathVariable int productId) {
        cartService.removeItemFromCart(userId, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/removeItemsFromCartToOrder/{userId}") // Endpoint to remove items from cart by user ID
    public ResponseEntity<Void> removeItemsFromCartToOrder(@PathVariable int userId) {
        cartService.removeItemsFromCartToOrder(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{userId}/{productId}")
    public ResponseEntity<Void> updateItemQuantity(@PathVariable int userId, @PathVariable int productId, @RequestParam int quantity) {
        cartService.updateItemQuantity(userId, productId, quantity);
        return ResponseEntity.ok().build();
    }


}
