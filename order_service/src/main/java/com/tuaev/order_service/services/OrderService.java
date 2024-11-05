package com.tuaev.order_service.services;

import com.tuaev.order_service.dto.OrderDTO;
import com.tuaev.order_service.entity.Order;

public interface OrderService {
    Order save(OrderDTO orderDTO);
}
