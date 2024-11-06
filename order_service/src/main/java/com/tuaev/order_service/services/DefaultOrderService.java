package com.tuaev.order_service.services;

import com.tuaev.order_service.dto.OrderDTO;
import com.tuaev.order_service.entity.Order;
import com.tuaev.order_service.entity.User;
import com.tuaev.order_service.repositories.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DefaultOrderService implements OrderService{

    private RestTemplate restTemplate;
    private OrderRepo orderRepo;
    private UserService userService;

    @Transactional
    @Override
    public Order save(OrderDTO orderDTO) {
        Order order = orderRepo.save(create(orderDTO));
        Long orderId = order.getId();
        sendOrder(orderId);
        return order;
    }

    private void sendOrder(Long orderId) {
        restTemplate.postForEntity("http://localhost:8081/api/v1/status", orderId, Object.class);
    }

    private Order create(OrderDTO orderDTO){
        User user = userService.findByEmail(orderDTO.getUserEmail());
        return new Order(
                orderDTO.getAddress(),
                orderDTO.getPaymentMethod(),
                orderDTO.getComments(),
                orderDTO.getUserEmail(),
                user,
                LocalDateTime.now()
        );
    }
}
