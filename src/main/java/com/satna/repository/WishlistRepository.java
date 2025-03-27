package com.satna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satna.model.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Wishlist findByUserId(Long userId);
}
