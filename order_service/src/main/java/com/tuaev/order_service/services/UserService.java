package com.tuaev.order_service.services;

import com.tuaev.order_service.dto.UserDTO;
import com.tuaev.order_service.entity.User;

public interface UserService {
    User findByEmail(String email);

    UserDTO save(UserDTO userDTO);
}
