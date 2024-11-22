package com.tuaev.order_service.services;

import com.tuaev.order_service.mapper.UserMapper;
import com.tuaev.order_service.dto.UserDTO;
import com.tuaev.order_service.entity.User;
import com.tuaev.order_service.repositories.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService{

    private UserRepo userRepo;
    private UserMapper userMapper;

    @Transactional
    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        userRepo.save(create(userDTO));
        return userDTO;
    }

    private User create(UserDTO userDTO){
        return userMapper.toUser(userDTO);
    }
}
