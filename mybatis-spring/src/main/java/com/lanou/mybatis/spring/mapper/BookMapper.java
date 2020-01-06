package com.lanou.mybatis.spring.mapper;

import com.lanou.mybatis.spring.bean.Book;
import java.util.List;

public interface BookMapper {
    int insert(Book record);

    List<Book> selectAll();
}