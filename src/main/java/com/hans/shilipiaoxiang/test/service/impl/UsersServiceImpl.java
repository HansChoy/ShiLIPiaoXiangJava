package com.hans.shilipiaoxiang.test.service.impl;

import com.hans.shilipiaoxiang.test.mapper.UsersMapper;
import com.hans.shilipiaoxiang.test.pojo.Users;
import com.hans.shilipiaoxiang.test.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    //自动装配RedisTemplate，操作redis的bean
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;


    @Override
    public /* 用锁锁住，队列进入，防止高并发synchronized*/ List<Users> selectAll() {

        //字符串的序列化器 序列化key
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        List<Users> userslist = (List<Users>) redisTemplate.opsForValue().get("allusers");


        //双重检测锁，锁定第一批同时进来的用户，队列进入
        if (userslist==null) {
            synchronized (this) {
                userslist = (List<Users>) redisTemplate.opsForValue().get("allusers");

                if (null == userslist) {
                    userslist = usersMapper.selectByExample(null);
                    redisTemplate.opsForValue().set("allusers", userslist);
                }

            }
        }




        return userslist;
    }

    @Override
    public Users selectById(int id) {
        return usersMapper.selectByPrimaryKey(id);
    }
}
