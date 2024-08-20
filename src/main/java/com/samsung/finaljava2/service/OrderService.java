package com.samsung.finaljava2.service;

import com.samsung.finaljava2.repository.OrderDetailRepo;
import com.samsung.finaljava2.repository.OrderRepo;
import com.samsung.finaljava2.repository.model.Order;
import com.samsung.finaljava2.repository.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Override
    public List<Order> getOrders(long user_id) {
        return orderRepo.findAllByUserId(user_id);
    }

    @Override
    public List<OrderDetail> getOrderDetail(long order_id) {
        return orderDetailRepo.findAllByOserId(order_id);
    }
}
