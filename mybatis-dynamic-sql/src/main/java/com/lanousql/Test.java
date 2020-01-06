package com.lanousql;

import com.lanousql.Mymapper.mapperdao;
import com.lanousql.bean.Student;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {


    public static void main(String[] args) throws IOException {
        InputStream is= Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession =  sqlSessionFactory.openSession(true);
        mapperdao testMapper =   sqlSession.getMapper(mapperdao.class);
        //queryAllUserByCondition(testMapper);
       // testQueryByIn(testMapper);
        //testinsert(testMapper);
        testInsertExecutorBatch(sqlSessionFactory,  testMapper);

    }

//    public  static void queryAllUserByCondition(mapperdao testMapper){
//
//        //Student student = new Student();
//        //student.setId(26);
//        //student.setName("王%");
//        //student.setNum(37);
////        List<Student> userList = testMapper.queryAllUserByCondition(student);
////        for(Student student1 :userList){
////            System.out.println(student1);
//        }
//    }


    public  static  void testQueryByIn( mapperdao testMapper){
     List<Student> list =    testMapper.queryUserByIn(Arrays.asList(new Integer[]{1, 10, 20}));
        System.out.println(list);
    }

     public  static  void testinsert( mapperdao testMapper ){
        List<Student> list= new ArrayList<>();
        list.add( new Student(100,100,"张三","男",25));
         int rows= testMapper.batchInsertByDynamicSql(list);
         System.out.println(rows);
}

public  static void testInsertExecutorBatch( SqlSessionFactory sqlSessionFactory, mapperdao testMapper ){
      SqlSession sqlSession   =  sqlSessionFactory.openSession(ExecutorType.BATCH,true);
      List<Student> list= new ArrayList<>();
    for(int i=100;i<200;i++){
        list.add( new Student(null,null,"张三","男",25));
        list.add( new Student(null,null,"李四","男",20));
    }

    int batchSize =100;
    int count = 0;
    List<BatchResult> resultList = new ArrayList<>();
    for(Student student : list) {
        // ExecutorType.Batch方式这里返回的不是影响的条数，具体获取方法参见下面代码
        testMapper.insertByExecutorBatch(student);
        count++;
        if(count % batchSize == 0) {
            resultList.addAll(sqlSession.flushStatements());
        }
    }
    if(count % batchSize != 0) {
        resultList.addAll(sqlSession.flushStatements());
    }
    int rows = 0;
    for(BatchResult batchResult : resultList) {
        int[] updateCounts = batchResult.getUpdateCounts();
        for(int updateCount : updateCounts) {
            rows += updateCount;
        }
    }
    System.out.println("批量插入成功，响应的行数：" + rows);

}


}
