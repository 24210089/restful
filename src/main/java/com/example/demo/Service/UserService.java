package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.demo.Controller.UserController;
import com.example.demo.Domain.User;
import com.example.demo.Respository.UserRepository;

@Service
public class UserService {

    private final Controller.UserController userController;
    private UserRepository userRepository;

    public UserService(UserRepository userRepository, Controller.UserController userController) {
        this.userRepository = userRepository;
        this.userController = userController;
    }

    public User createNewUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public List<User> fetchAllUsers() {
        return this.userRepository.findAll();
    }

}
