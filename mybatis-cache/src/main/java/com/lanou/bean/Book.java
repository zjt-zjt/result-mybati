package com.lanou.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@Setter
@Getter
public class Book {
    private String bookNo;

    private String bookName;

    private String bookType;

    private String author;

//    private Timestamp publishDate;
//
//    private String bookCover;
//
   private Integer stock;


}