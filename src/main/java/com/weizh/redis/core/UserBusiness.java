package com.weizh.redis.core;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.weizh.redis.dao.UserDao;
import com.weizh.redis.domain.User;

@Service
public class UserBusiness {
    
    @Resource
    private UserDao userDaoImpl;
    
    public void addUser(String name, String value) {
        userDaoImpl.addUser(name, value);
    }
    
    public Object getUser(String name) {
        return userDaoImpl.getUser(name);
    }
    
    public void add(User user) {
        userDaoImpl.add(user);
    }
    
    public User get(String id) {
        return userDaoImpl.get(id);
    }
    
    public static void main(String[] args) {
        String path = UserBusiness.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        System.out.println(path);
    }
}
