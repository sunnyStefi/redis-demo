package com.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.redis.model.User;
import com.redis.service.UserService;

@RestController
public class UserController {

    @Autowired // lifecycle management (new), maintanability
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (userService.createUser(user)){
            return ResponseEntity.ok("User created successfully");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> allUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
