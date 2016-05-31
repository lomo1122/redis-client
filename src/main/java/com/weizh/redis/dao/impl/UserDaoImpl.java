package com.weizh.redis.dao.impl;

import org.springframework.stereotype.Repository;

import com.weizh.redis.dao.UserDao;
import com.weizh.redis.domain.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    
    public Object getUser(String name) {
        return redisTemplate.opsForValue().get(name);
    }
    
    public void addUser(String name, String value) {
        redisTemplate.opsForValue().set(name, value);
    }
    
    public void add(User user) {
        redisTemplate.opsForValue().set(user.getId(), user);
    }
    
    public User get(String id) {
        return (User) redisTemplate.opsForValue().get(id);
    }
    
}
