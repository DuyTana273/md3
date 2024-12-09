package com.demo.test.service.cart;

import com.demo.test.model.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartService {
    // Create
    void addCart(Cart cart);

    // Find
    List<Cart> findAllCart();
    Optional<Cart> findCartById(int cartId);
    List<Cart> searchCart(String searchKeyword);

    // Update
    void updateCart(Cart cart);

    // Delete
    boolean deleteCartById(int cartId);
}
