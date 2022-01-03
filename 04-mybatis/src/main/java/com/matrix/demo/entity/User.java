package com.matrix.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Component
//@Alias(value="user")
public class User {
    private Integer id;
    private String name;
    private Byte sex;
    private String email;
    private String phone;
    private Byte status;
}
