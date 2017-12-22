package com.xhc.test.mybatis;

import com.xhc.test.mybatis.domain.Classes;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by mymac on 2017/11/29.
 *
 * 联合查询测试，
 * 1.使用一个sql关联查询，用resultMap做结果映射，association做属性对象映射、collection做属性集合映射
 * 2.使用多个sql查询组装一个resultMap对象， 在association、collection标签中使用select 指定查询的select id
 */
public class AssociationTableTest {


    @Test
    public void assocaiationOneSqlTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        String statement = "mybatis.mapper.classMapper.getClass";//映射sql的标识字符串

        Classes clazz = sqlSession.selectOne(statement,1);//查询class表中id为1的记录

        sqlSession.close();
        System.out.println(clazz);
    }


    @Test
    public void assocaiationMultiSqlTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        String statement = "mybatis.mapper.classMapper.getClass2";

        Classes clazz = sqlSession.selectOne(statement,1);

        sqlSession.close();

        System.out.println(clazz);
    }
}
