package com.tuaev.order_service.services;

import com.tuaev.order_service.dto.OrderDTO;

public interface OrderService {
    OrderDTO save(OrderDTO orderDTO);
}
