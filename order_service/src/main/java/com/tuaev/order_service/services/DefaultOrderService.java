package com.tuaev.order_service.services;

import com.tuaev.order_service.dto.OrderDTO;
import com.tuaev.order_service.entity.Order;
import com.tuaev.order_service.entity.User;
import com.tuaev.order_service.repositories.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DefaultOrderService implements OrderService{

    private OrderRepo orderRepo;
    private UserService userService;

    @Transactional
    @Override
    public Order save(OrderDTO orderDTO) {
        return orderRepo.save(create(orderDTO));
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
