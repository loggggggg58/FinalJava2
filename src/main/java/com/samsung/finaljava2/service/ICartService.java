package com.samsung.finaljava2.service;

import com.samsung.finaljava2.repository.model.Cart;

import java.util.List;

public interface ICartService {
    public List<Cart> getCart(long user_id);
    public void addCart(long user_id, long product_id, long quantity);
    public void removeProductInCart(long user_id, long product_id);
    public int countProduct(long user_id);
    public int totalPrice(long user_id);
    public void checkout(long user_id);
}
