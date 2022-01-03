package com.matrix.redisdemo.entity;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;


@Data
@ToString
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Integer age;
}
