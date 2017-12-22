package com.xhc.test.mybatis;

import com.xhc.test.mybatis.domain.Classes;
import com.xhc.test.mybatis.domain.User;
import com.xhc.test.mybatis.mapping.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by mymac on 2017/11/29.
 *
 * 一级缓存基于PerpetualCache的 HashMap,作用范围为sqlsession， 执行sqlsession flush\close将清空缓存
 *
 * 二级缓存也基于PerpetualCache 的本地缓存作用域为Mapper（namespace）一个Mapper配置文件，
 *
 * 一二级缓存在一个namespace 中执行了新增、修改、删除后缓存将clear
 */
public class CacheTest {

    /**
     * 只查询一次
     */
    @Test
    public void oneLevelTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);

        String statement = "mybatis.mapper.userMapper.getUser";//映射sql的标识字符串

        User user = sqlSession.selectOne(statement, 4);

        System.out.println(user);

        user = sqlSession.selectOne(statement, 4);

        System.out.println(user);

        sqlSession.close();
    }

    /**
     * 两次查询中间修改过一次，第二次不会走cache
     */
    @Test
    public void oneLevelTest2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);

        //UserMapper通过动态代理实现
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getById(4);

        System.out.println(user);

        User user2 = new User(4, "姚明3", 40);
        int i = mapper.update(user2);
        System.out.println("after update user is " + user2);

        user = mapper.getById(4);
        System.out.println(user);

        sqlSession.close();
    }

    /**
     * 使用一个sessionFactory创建的2个session，查同样sql使用了2级缓存
     */
    @Test
    public void twoLevelTest() {
        SqlSessionFactory factory = MybatisUtil.getSqlSessionFactory();
        //开启两个不同的SqlSession
        SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();

        String statement = "mybatis.mapper.userMapper.getUser";//映射sql的标识字符串

        User user = sqlSession.selectOne(statement, 4);

        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();

        user = sqlSession2.selectOne(statement, 4);

        System.out.println(user);
        sqlSession2.close();

    }

    /**
     * 两个session两次查询同一个sql，查询间执行过一次add，第二次查询会不走cache
     */
    @Test
    public void twoLevelTest2() {
        SqlSessionFactory factory = MybatisUtil.getSqlSessionFactory();
        //开启两个不同的SqlSession
        SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();

        String statement = "mybatis.mapper.userMapper.getUser";
        String statement2 = "mybatis.mapper.userMapper.addUser";

        User user = sqlSession.selectOne(statement, 4);

        System.out.println(user);
        sqlSession.commit();

        User user2 = new User(8, "乔丹", 31);
        sqlSession.insert(statement2, user2);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("add user " + user2);

        user = sqlSession2.selectOne(statement, 4);

        System.out.println(user);
        sqlSession2.close();

    }
}
