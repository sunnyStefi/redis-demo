package com.redis.repository;

import java.util.List;

import com.redis.model.User;

public interface UserDAO {

    boolean save(User user);
    List<User> findAll();
    User findById(int id);
    
}
