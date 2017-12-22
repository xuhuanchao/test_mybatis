package com.xhc.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mymac on 2017/11/30.
 */
public class ProcedureTest {

    @Test
    public void testGetUserCount(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        String statement = "mybatis.mapper.userMapper.getUserCount";//映射sql的标识字符串
        Map<String, Integer> parameterMap = new HashMap<String, Integer>();
        parameterMap.put("sexid", 1);
        parameterMap.put("usercount", -1);

        sqlSession.selectOne(statement, parameterMap);
        Integer result = parameterMap.get("usercount");
        System.out.println(result);
        sqlSession.close();
    }
}
