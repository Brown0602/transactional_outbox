package com.tuaev.order_service.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDTO {

    private String address;
    private String paymentMethod;
    private String comments;
    private String userEmail;
    private UserDTO userDTO;
    private LocalDateTime dateTime;
}
