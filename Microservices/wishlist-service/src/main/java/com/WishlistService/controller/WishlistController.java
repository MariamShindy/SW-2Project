package com.WishlistService.controller;
import com.WishlistService.dto.WishlistRequest;
import com.WishlistService.model.Wishlist;
import com.WishlistService.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/wishlist")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Wishlist>> getUserWishlist(@PathVariable int userId) {
        List<Wishlist> wishlist = wishlistService.getUserWishlist(userId);
        return ResponseEntity.ok(wishlist);
    }

    @PostMapping("/addItemToWishlist")
    public ResponseEntity<Wishlist> addItemToWishlist(@RequestBody WishlistRequest wishlistItemRequest) {
        Wishlist addedItem = wishlistService.addItemToWishlist(wishlistItemRequest);
        return ResponseEntity.ok(addedItem);
    }

    @DeleteMapping("/{userId}/items/{productId}")
    public ResponseEntity<Void> removeFromWishlist(@PathVariable int userId, @PathVariable int productId) {
        wishlistService.removeItemFromWishlist(userId, productId);
        return ResponseEntity.noContent().build();
    }


}
