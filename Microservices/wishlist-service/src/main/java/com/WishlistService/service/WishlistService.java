package com.WishlistService.service;

import com.WishlistService.dto.WishlistRequest;
import com.WishlistService.model.Wishlist;
import com.WishlistService.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;
    private static final Logger logger = Logger.getLogger(WishlistService.class.getName());

    public List<Wishlist> getUserWishlist(int userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Wishlist addItemToWishlist(WishlistRequest wishlistItemRequest) {
        Wishlist wishlistItem = mapWishlistItemRequestToWishlistItem(wishlistItemRequest);
        return wishlistRepository.save(wishlistItem);
    }

    public void removeItemFromWishlist(int userId , int productId) {
        Optional<Wishlist> wishlistItemOptional = wishlistRepository.findByUserIdAndProductId(userId, productId);
        if (wishlistItemOptional.isPresent()) {
            Wishlist wishlistItem = wishlistItemOptional.get();
            wishlistRepository.delete(wishlistItem);
            logger.info("Item removed from wishlist successfully");
        } else {
            throw new IllegalArgumentException("Wishlist item with Product ID " + productId + " does not exist for user ID " + userId + ".");
        }
    }

    private Wishlist mapWishlistItemRequestToWishlistItem(WishlistRequest wishlistItemRequest){
        Wishlist wishlist = new Wishlist();
        wishlist.setProductId(wishlistItemRequest.getProductId());
        wishlist.setUserId(wishlistItemRequest.getUserId());
        return wishlist;
    }
}
