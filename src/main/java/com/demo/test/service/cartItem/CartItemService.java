package com.demo.test.service.cartItem;

import com.demo.test.model.CartItem;
import com.demo.test.repository.cartItem.CartItemRepo;
import com.demo.test.repository.cartItem.ICartItemRepo;

import java.util.List;

public class CartItemService implements ICartItemService {
    private final ICartItemRepo iCartItemRepo = new CartItemRepo();

    @Override
    public boolean addCartItem(CartItem cartItem) {
        return iCartItemRepo.addCartItem(cartItem);
    }

    @Override
    public CartItem findCartItemById(int cartItemId) {
        return iCartItemRepo.findCartItemById(cartItemId);
    }

    @Override
    public List<CartItem> findCartItemsByCartId(int cartId) {
        return iCartItemRepo.findCartItemsByCartId(cartId);
    }

    @Override
    public CartItem findCartItemByCartIdAndProductId(int cartId, int productId) {
        return iCartItemRepo.findCartItemByCartIdAndProductId(cartId, productId);
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) {
        return iCartItemRepo.updateCartItem(cartItem);
    }

    @Override
    public boolean updateCartItemQuantityAndTotal(int cartItemId, int quantity, double cartTotal) {
        return iCartItemRepo.updateCartItemQuantityAndTotal(cartItemId, quantity, cartTotal);
    }

    @Override
    public boolean deleteCartItemById(int cartItemId) {
        return iCartItemRepo.deleteCartItemById(cartItemId);
    }

    @Override
    public double calculateCartItemTotal(int cartItemId) {
        return iCartItemRepo.calculateCartItemTotal(cartItemId);
    }
}
