package com.lanou.mybatis.spring.service;

import com.lanou.mybatis.spring.bean.Book;
import com.lanou.mybatis.spring.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public List<Book> queryAllMessage() {
        return bookMapper.selectAll();
    }
}
