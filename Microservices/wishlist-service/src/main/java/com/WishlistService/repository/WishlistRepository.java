package com.WishlistService.repository;

import com.WishlistService.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    List<Wishlist> findByUserId(int userId);

    Optional<Wishlist> findByUserIdAndProductId(int userId , int productId);
}
