package com.tuaev.order_service.controllers;

import com.tuaev.order_service.dto.UserDTO;
import com.tuaev.order_service.entity.User;
import com.tuaev.order_service.services.UserService;
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
public class UserController {

    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<User> save(@RequestBody UserDTO userDTO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(userDTO));
    }
}
