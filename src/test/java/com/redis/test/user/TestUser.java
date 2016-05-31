package com.redis.test.user;

import javax.annotation.Resource;

import org.junit.Test;

import com.redis.test.BaseContext;
import com.weizh.redis.core.UserBusiness;
import com.weizh.redis.domain.User;

public class TestUser extends BaseContext {
    
    @Resource
    private UserBusiness userBusiness;
    
    @Test
    public void addUser() {
        userBusiness.addUser("name", "weizh");
    }
    
    @Test
    public void getUser() {
        System.out.println(userBusiness.getUser("name"));
    }
    
    @Test
    public void add() {
        User user = new User();
        
        user.setId("1234567890");
        user.setName("weizh");
        userBusiness.add(user);
    }
    
    @Test
    public void get() {
        User user = userBusiness.get("1234567890");
        System.out.println(user);
        System.out.println(user.getId());
        System.out.println(user.getName());
    }
    
}
