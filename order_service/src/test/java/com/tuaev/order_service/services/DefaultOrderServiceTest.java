package com.tuaev.order_service.services;

import com.tuaev.order_service.repositories.OrderRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
        //
    }
}
