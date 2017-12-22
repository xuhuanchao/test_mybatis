package com.xhc.test.mybatis;

import com.xhc.test.mybatis.domain.Order;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by mymac on 2017/11/28.
 *
 * 查询结果字段名与实体bean属性名不同的查询
 * 使用resultMap做查询结果的例子
 *
 * <resultMap>标签包含自标签说明：
 * <id> \ <result> property:对象属性   column:查询字段
 */
public class ResultMapTest {


    @Test
    public void differentPropertiesTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        String statement = "mybatis.mapper.orderMapper.selectOrder";

        Order order = sqlSession.selectOne(statement,1);

        sqlSession.close();
        System.out.println(order);
    }



    @Test
    public void userResultMapTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        String statement = "mybatis.mapper.orderMapper.selectOrderResultMap";

        Order order = sqlSession.selectOne(statement,1);

        sqlSession.close();
        System.out.println(order);
    }
}
