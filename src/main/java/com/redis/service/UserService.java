package com.redis.service;

import java.util.List;

import com.redis.model.User;

public interface UserService {
    boolean createUser(User user);
    List<User> getAllUsers();
    User getUser(int id);
}
