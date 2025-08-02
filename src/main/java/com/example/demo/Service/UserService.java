package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

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

    public User updateUser(Long id, User requestUser) {
        User currentUser = this.fetchUserById(id);
        if (currentUser != null) {
            currentUser.setEmail(requestUser.getEmail());
            currentUser.setName(requestUser.getName());
            currentUser.setPassword(requestUser.getPassword());
            return this.userRepository.save(currentUser);

        }
        return null;
    }

}
