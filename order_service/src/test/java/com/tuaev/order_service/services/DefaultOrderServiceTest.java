package com.tuaev.order_service.services;

import com.tuaev.order_service.dto.OrderDTO;
import com.tuaev.order_service.entity.Order;
import com.tuaev.order_service.entity.User;
import com.tuaev.order_service.repositories.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class DefaultOrderServiceTest {

    @MockBean
    private OrderRepo orderRepo;
    @MockBean
    private UserService userService;
    @Autowired
    private OrderService orderService;

    @Test
    void testSave(){
        when(userService.findByEmail(anyString())).thenReturn(new User());
        when(orderRepo.save(any(Order.class))).thenReturn(new Order());
        Order result = orderService.save(new OrderDTO());
        assertNotNull(result);
    }
}
