package com.lanou.mybatis.spring.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Date;
@ToString
@Setter
@Getter
public class Book {
    private String bookNo;

    private String bookName;

    private String bookType;

    private String author;

    private Timestamp publishDate;

    private String bookCover;

    private Integer stock;


}