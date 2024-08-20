package com.samsung.finaljava2.repository;

import com.samsung.finaljava2.repository.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query(value = "select * from orders where user_id = ?1", nativeQuery = true)
    public List<Order> findAllByUserId(long user_id);
}
