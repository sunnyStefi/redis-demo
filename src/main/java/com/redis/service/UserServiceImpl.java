package com.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.model.User;
import com.redis.repository.UserDAO;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDAO userDao;
    
    @Override
    public boolean createUser(User user){
       return userDao.save(user);
      }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUser(int id) {
        return userDao.findById(id);
    }

}
