package com.weizh.redis.dao;

import com.weizh.redis.domain.User;

public interface UserDao {
    
    void addUser(String name, String value);
    
    Object getUser(String name);
    
    void add(User user);
    
    User get(String id);
    
}
