package com.redis.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.model.User;

    @Repository
    public class UserDAOImpl implements UserDAO {

        @Autowired
        private RedisTemplate redisTemplate;
        private static final String KEY = "USER";
        
        @Override
        public boolean save(User user){
            try{
                redisTemplate.opsForHash().put(KEY, String.valueOf(user.getId()), user);
                return true;
            }
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
        }

    @Override
    public List<User> findAll(){
        try{
            List<Object> userMap = redisTemplate.opsForHash().values(KEY);
            return userMap.stream().map(user -> (User) user).collect(Collectors.toList());
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override 
    public User findById(int id){
        try{
            return (User) redisTemplate.opsForHash().get(KEY, String.valueOf(id));
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
