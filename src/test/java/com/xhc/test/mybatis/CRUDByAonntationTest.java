package com.xhc.test.mybatis;

import com.xhc.test.mybatis.domain.User;
import com.xhc.test.mybatis.mapping.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by mymac on 2017/11/28.
 *
 * 通过在接口上使用注解方式使用
 * mybatis会创建接口的动态代理
 * 用户直接使用接口对象调用方法
 */
public class CRUDByAonntationTest {



    @Test
    public void testAdd(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);

        //UserMapper通过动态代理实现
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("天气预报");
        user.setAge(99);
        int add = mapper.add(user);
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(add);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);

        //UserMapper通过动态代理实现
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(6);
        user.setName("大地制造");
        user.setAge(26);
        //执行修改操作
        int retResult = mapper.update(user);

        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);

        //UserMapper通过动态代理实现
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //执行删除操作
        int retResult = mapper.deleteById(6);

        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testGetUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //UserMapper通过动态代理实现
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getById(4);

        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void testGetAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> lstUsers = mapper.getAll();

        sqlSession.close();
        System.out.println(lstUsers);
    }
}
