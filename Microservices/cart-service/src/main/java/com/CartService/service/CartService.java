package com.CartService.service;
import com.CartService.dto.CartRequest;
import com.CartService.model.Cart;
import com.CartService.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    private static final Logger logger = Logger.getLogger(CartService.class.getName());

    public List<Cart> getUserCart(int userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart addItemToCart(CartRequest cartItemRequest) {
        if (cartItemRequest.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        // Check if item already exists in cart, if so, update quantity
        Optional<Cart> existingCartItem = cartRepository.findByUserIdAndProductId(cartItemRequest.getUserId() , cartItemRequest.getProductId());
        if (existingCartItem.isPresent()) {
            Cart cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + cartItemRequest.getQuantity());
            return cartRepository.save(cartItem);
        } else {
            // Create new cart item
            Cart cartItem = mapCartItemRequestToCartItem(cartItemRequest);
            return cartRepository.save(cartItem);
        }
    }

    public void removeItemFromCart(int userId , int productId) {
        Optional<Cart> cartItemOptional = cartRepository.findByUserIdAndProductId(userId, productId);

        // Check if the cart item exists
        if (cartItemOptional.isPresent()) {
            // If the cart item exists, delete it from the repository
            cartRepository.delete(cartItemOptional.get());
            logger.info("Cart item deleted successfully");
        } else {
            throw new IllegalArgumentException("Cart item with Product ID " + productId + " does not exist for user ID " + userId + ".");
        }
    }

    //remove items from cart after placing an order
    public void removeItemsFromCartToOrder(int userId){
     List<Cart> userCart = cartRepository.findByUserId(userId);
     cartRepository.deleteAll();
     logger.info("Cart items deleted successfully after placing the order");
    }

    public void updateItemQuantity(int userId, int productId, int quantity) {
        // Find the cart entry by user ID and product ID
        Optional<Cart> cartEntryOptional = cartRepository.findByUserIdAndProductId(userId, productId);

        if (cartEntryOptional.isPresent()) {
            // If the cart entry exists, update its quantity
            Cart cartEntry = cartEntryOptional.get();
            cartEntry.setQuantity(quantity);
            cartRepository.save(cartEntry);
            logger.info("Item quantity updated successfully");
        } else {
            throw new IllegalArgumentException("Cart item with Product ID " + productId + " does not exist for user ID " + userId + ".");
        }
    }

    private Cart mapCartItemRequestToCartItem(CartRequest cartRequest){
        Cart cart = new Cart();
        cart.setCartId(cartRequest.getUserId());
        cart.setQuantity(cartRequest.getQuantity());
        cart.setUserId(cartRequest.getUserId());
        cart.setProductId(cartRequest.getProductId());
        return cart;
    }

}

