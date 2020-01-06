package com.lanou.mybatis.spring;

import com.lanou.mybatis.spring.bean.Book;
import com.lanou.mybatis.spring.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = ctx.getBean(BookService.class);
        List<Book> list = bookService.queryAllMessage();
        for(Book book:list){
            System.out.println(book);
        }
    }
}
