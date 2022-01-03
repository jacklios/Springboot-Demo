package com.matrix.demo.mapper;

import java.util.List;
import com.matrix.demo.entity.User;
import org.apache.ibatis.annotations.Select;


public interface UserMapper2 {
    @Select(value = "select *  from user")
    public List<User> selectAll();
}
