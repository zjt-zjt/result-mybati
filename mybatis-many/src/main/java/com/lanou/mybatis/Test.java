package com.lanou.mybatis;

import com.lanou.mybatis.bean.Teacher;
import com.lanou.mybatis.mapperTest.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws IOException {

        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        TestMapper testMapper =   sqlSession.getMapper(TestMapper.class);

        Teacher teacher = testMapper.findByTId(1);
        System.out.println(teacher);


    }
}
