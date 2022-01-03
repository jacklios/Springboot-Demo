package com.matrix.demo.service;

import java.util.List;

import javax.annotation.Resource;
import com.matrix.demo.entity.User;
import com.matrix.demo.mapper.UserMapper;
import com.matrix.demo.mapper.UserMapper2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserMapper2 userMappe2;

    public User getById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public void add(User user) {
        userMapper.insertUser(user);
    }

    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public List<User> getAll() {
        return userMappe2.selectAll();
    }
}
