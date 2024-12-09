package com.demo.test.service.cart;

import com.demo.test.model.Cart;
import com.demo.test.repository.cart.CartRepo;
import com.demo.test.repository.cart.ICartRepo;

import java.util.List;
import java.util.Optional;

public class CartService implements ICartService {
    private final ICartRepo iCartRepo = new CartRepo();

    public CartService() {
    }

    @Override
    public void addCart(Cart cart) {
        iCartRepo.addCart(cart);
    }

    @Override
    public List<Cart> findAllCart() {
        return iCartRepo.findAllCart();
    }

    @Override
    public Optional<Cart> findCartById(int cartId) {
        return iCartRepo.findCartById(cartId);
    }

    @Override
    public List<Cart> searchCart(String searchKeyword) {
        return iCartRepo.searchCart(searchKeyword);
    }

    @Override
    public void updateCart(Cart cart) {
        iCartRepo.updateCart(cart);
    }

    @Override
    public boolean deleteCartById(int cartId) {
        return iCartRepo.deleteCartById(cartId);
    }
}
