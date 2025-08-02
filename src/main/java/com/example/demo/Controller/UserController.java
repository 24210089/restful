package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.User;
import com.example.demo.Service.UserService;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Tạo User
    @PostMapping("/user")
    public User createNewUser(@RequestBody User user) {
        User newUser = this.userService.createNewUser(user);
        return newUser;
    }

    // Delete User
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUserById(id);
        return "id " + id + " da duoc xoa";
    }

    // Lấy thông tin user qua ID
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        User user = this.userService.fetchUserById(id);
        return user;
    }

    // Lấy thông tin toàn bộ User
    @GetMapping("/user")
    public List<User> getAllUsers() {
        List<User> listUser = this.userService.fetchAllUsers();
        return listUser;
    }
}
