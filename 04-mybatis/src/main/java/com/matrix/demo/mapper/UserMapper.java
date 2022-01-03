package com.matrix.demo.mapper;

import com.matrix.demo.entity.User;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    long countByUser(User user);

    int insertUser(User user);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(User user);

}