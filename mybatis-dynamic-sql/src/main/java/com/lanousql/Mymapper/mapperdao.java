package com.lanousql.Mymapper;

import com.lanousql.bean.Student;

import java.util.List;

public interface mapperdao {

    List<Student> queryAllUserByCondition(Student student);
    List<Student> queryUserByIn(List<Integer> ids);
    int batchInsertByDynamicSql(List<Student> studentsList);
    int insertByExecutorBatch(Student student);

}
