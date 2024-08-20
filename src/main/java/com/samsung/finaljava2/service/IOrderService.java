package com.samsung.finaljava2.service;

import com.samsung.finaljava2.repository.model.Order;
import com.samsung.finaljava2.repository.model.OrderDetail;

import java.util.List;

public interface IOrderService {
    public List<Order> getOrders(long user_id);
    public List<OrderDetail> getOrderDetail(long order_id);
}
