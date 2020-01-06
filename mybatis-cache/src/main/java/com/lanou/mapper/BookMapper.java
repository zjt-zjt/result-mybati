package com.lanou.mapper;

import com.lanou.bean.Book;

import java.util.List;

public interface BookMapper {
    List<Book> queryAll();
    void updateBook(Book firstBook);
}
