package com.samsung.finaljava2.repository;

import com.samsung.finaljava2.repository.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select * from order_details where order_id = ?1", nativeQuery = true)
    public List<OrderDetail> findAllByOserId(long user_id);
}
