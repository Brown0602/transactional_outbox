package com.tuaev.order_service.services;

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

    @Transactional
    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User save(UserDTO userDTO) {
        return userRepo.save(create(userDTO));
    }

    private User create(UserDTO userDTO){
        return new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
    }
}
