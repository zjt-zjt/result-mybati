package com.lanou.mybatis.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Teacher {
    private  Integer id;
    private  String tname;
    private String tsex;
    private List<Student> students;
    private Classroom classroom;
}
