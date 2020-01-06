package com.lanou;

import com.lanou.bean.Book;
import com.lanou.mapper.BookMapper;
import com.lanou.utils.MyBatisTools;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    public static void main(String[] args) {
       testOneCache();
       //testSecondCache();
    }


    public static  void testOneCache(){
         //不在用一个缓存
        SqlSession sqlSession   =   MyBatisTools.getInstance().openSession(true);
        for(int i = 0; i < 10; i++) {
           // SqlSession sqlSession   =   MyBatisTools.getInstance().openSession(true);
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            List<Book> books = bookMapper.queryAll();

            Book firstBook = null;
            for (Book book : books) {
                System.out.println("第" + i + "次");
                System.out.println(book);
                // 1. 获取本次结果集中的第一条数据，标记出来
                if (firstBook == null) {
                    firstBook = book;
                }
            }
              bookMapper.updateBook(firstBook);
        }

    }

    private static void testSecondCache() {

        for(int i = 0; i < 10; i++) {
            SqlSession sqlSession = MyBatisTools.getInstance().openSession(false);
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            List<Book> books = bookMapper.queryAll();
            Book targetBook = null;
            int idx = 0;
            for(Book book : books) {
                System.out.println("第" + i +"次");
                System.out.println(book);
                // 1. 获取本次结果集中的第一条数据，标记出来
                idx ++;
                if(idx == 3) {
                    targetBook = book;
                }
            }
            //sqlSession.close();
            //sqlSession.flushStatements();
            //sqlSession.commit();
        }

    }




}
