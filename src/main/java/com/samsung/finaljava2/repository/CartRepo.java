package com.samsung.finaljava2.repository;

import com.samsung.finaljava2.repository.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart, Long> {
    @Query(value = "select * from carts where user_id = ?1", nativeQuery = true)
    public List<Cart> findAllByUserId(long user_id);

    @Query(value = "select * from carts where user_id = ?1 and product_id=?2", nativeQuery = true)
    public List<Cart> findProductByUserId(long user_id, long product_id);

    @Transactional
    @Modifying
    @Query(value = "update carts set quantity = quantity + ?3 where user_id = ?1 and product_id=?2", nativeQuery = true)
    public void updateQuantity(long user_id, long product_id, long quantity);

    @Transactional
    @Modifying
    @Query(value = "delete from carts where user_id = ?1 and product_id=?2", nativeQuery = true)
    public void removeProductInCart(long user_id, long product_id);

    @Transactional
    @Modifying
    @Query(value = "delete from carts where user_id = ?1", nativeQuery = true)
    public void clearCart(long user_id);
}
