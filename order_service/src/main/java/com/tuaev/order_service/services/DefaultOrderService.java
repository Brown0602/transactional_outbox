package com.tuaev.order_service.services;

import com.tuaev.order_service.dto.OrderDTO;
import com.tuaev.order_service.entity.Order;
import com.tuaev.order_service.entity.User;
import com.tuaev.order_service.mapper.OrderMapper;
import com.tuaev.order_service.repositories.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DefaultOrderService implements OrderService{

    private RestTemplate restTemplate;
    private OrderRepo orderRepo;
    private UserService userService;
    private OrderMapper orderMapper;


    @Transactional
    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = orderRepo.save(create(orderDTO));
        sendOrder(order.getId());
        return orderDTO;
    }

    private void sendOrder(Long orderId) {
        restTemplate.postForEntity("http://localhost:8081/api/v1/status", orderId, Object.class);
    }

    private Order create(OrderDTO orderDTO){
        User user = userService.findByEmail(orderDTO.getUserEmail());
        return orderMapper.toOrder(orderDTO, user, LocalDateTime.now());
    }
}
