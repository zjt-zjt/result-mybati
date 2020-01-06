package com.lanousql.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Student {
     private  Integer id;
     private  Integer num;
     private  String name;
      private  String sex;
     private  Integer age;

    public Student(Integer id, Integer num, String name, String sex, Integer age) {
        this.id = id;
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
