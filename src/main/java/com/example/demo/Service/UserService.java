package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Domain.User;
import com.example.demo.Respository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(User user) {
        return this.userRepository.save(user);

    }

}
