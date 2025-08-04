package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Domain.User;
import com.example.demo.Service.UserService;
import com.example.demo.Service.error.IdinvalidException;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Tạo User
    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        User newUser = this.userService.createNewUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // Xử lý ngoại lệ Exception
    @ExceptionHandler(IdinvalidException.class)
    public ResponseEntity<String> handleIdException(IdinvalidException idException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(idException.getMessage());
    }

    // Delete User
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws IdinvalidException {
        if (id > 20) {
            throw new IdinvalidException("Id <20");
        }
        this.userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }

    // Lấy thông tin user qua ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = this.userService.fetchUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    // Lấy thông tin toàn bộ User
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> listUser = this.userService.fetchAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(listUser);
    }

    // Cập nhật thông tin người dùng
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = this.userService.updateUser(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }
}
