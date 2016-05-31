/**
 * 
 */
package com.weizh.redis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.weizh.redis.dao.BaseDao;

/**
 * @description BaseDaoImpl.java
 * @author zhangwei
 * @date 2016年4月8日上午11:25:30
 * @version 0.1
 */
public class BaseDaoImpl implements BaseDao {
    
    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;
    
    @Autowired
    protected StringRedisTemplate stringRedisTemplate;
    
}
