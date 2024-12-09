package com.demo.test.service.cartItem;

import com.demo.test.model.CartItem;

import java.util.List;

public interface ICartItemService {
    // Create
    boolean addCartItem(CartItem cartItem);

    // Find
    CartItem findCartItemById(int cartItemId);
    List<CartItem> findCartItemsByCartId(int cartId);
    CartItem findCartItemByCartIdAndProductId(int cartId, int productId);

    // Update
    boolean updateCartItem(CartItem cartItem);
    boolean updateCartItemQuantityAndTotal(int cartItemId, int quantity, double cartTotal);

    // Delete
    boolean deleteCartItemById(int cartItemId);

    // Calculator
    double calculateCartItemTotal(int cartItemId);
}
