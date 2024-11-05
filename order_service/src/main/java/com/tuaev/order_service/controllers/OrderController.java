package com.tuaev.order_service.controllers;

import com.tuaev.order_service.dto.OrderDTO;
import com.tuaev.order_service.entity.Order;
import com.tuaev.order_service.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("order")
    public ResponseEntity<Order> save(@RequestBody OrderDTO orderDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.save(orderDTO));
    }
}
