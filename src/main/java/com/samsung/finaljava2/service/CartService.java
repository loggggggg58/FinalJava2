package com.samsung.finaljava2.service;

import com.samsung.finaljava2.repository.CartRepo;
import com.samsung.finaljava2.repository.OrderDetailRepo;
import com.samsung.finaljava2.repository.OrderRepo;
import com.samsung.finaljava2.repository.ProductRepo;
import com.samsung.finaljava2.repository.model.Cart;
import com.samsung.finaljava2.repository.model.Order;
import com.samsung.finaljava2.repository.model.OrderDetail;
import com.samsung.finaljava2.repository.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    CartRepo cartRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Override
    public List<Cart> getCart(long user_id) {
        return cartRepo.findAllByUserId(user_id);
    }

    @Override
    public void addCart(long user_id, long product_id, long quantity) {
        List<Cart> isExistProduct = cartRepo.findProductByUserId(user_id, product_id);

        if (isExistProduct.isEmpty()) {
            cartRepo.save(Cart.builder().user_id(user_id).product_id(product_id).quantity(quantity).build());
        } else {
            cartRepo.updateQuantity(user_id, product_id, quantity);
        }
    }

    @Override
    public void removeProductInCart(long user_id, long product_id) {
        cartRepo.removeProductInCart(user_id, product_id);
    }

    @Override
    public int countProduct(long user_id) {
        List<Cart> listCart = this.getCart(user_id);
        int count = 0;
        for (Cart cart : listCart) {
            count += cart.getQuantity();
        }
        return count;
    }

    @Override
    public int totalPrice(long user_id) {
        List<Product> listProduct = productRepo.findAll();

        List<Cart> listCart = this.getCart(user_id);
        int total = 0;
        for (Cart cart : listCart) {
            total += (cart.getQuantity() * listProduct.get(Math.toIntExact(cart.getProduct_id() - 1)).getPrice());
        }
        return total;
    }

    @Override
    public void checkout(long user_id) {
        Order order = Order.builder().user_id(user_id).total_qty(this.countProduct(user_id)).total_amount((long) this.totalPrice(user_id)).build();
        orderRepo.save(order);
        List<Product> listProduct = productRepo.findAll();
        List<Cart> listCart = this.getCart(user_id);

        for (Cart cart : listCart) {
            Product product = listProduct.get(Math.toIntExact(cart.getProduct_id() - 1));
            orderDetailRepo.save(OrderDetail
                    .builder().
                    product_id(product.getId())
                    .qty(Math.toIntExact(cart.getQuantity()))
                    .unit_price(product.getPrice())
                    .order_id(order.getId())
                    .build()
            );
        }

        cartRepo.clearCart(user_id);
    }
}
