package com.xhc.test.mybatis;

import com.xhc.test.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by mymac on 2017/11/28.
 */
public class CRUDBaseXMLTest {

    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);
        String statement = "mybatis.mapper.userMapper.addUser";

        User user = new User();
        user.setName("老猫");
        user.setAge(20);

        //执行插入操作
        int retResult = sqlSession.insert(statement,user);

        //手动提交事务
        //sqlSession.commit();

        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(retResult);
    }


    @Test
    public void testUpdate(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);

        String statement = "mybatis.mapper.userMapper.updateUser";//映射sql的标识字符串

        User user = new User();
        user.setId(4);
        user.setName("猕猴");
        user.setAge(21);

        int retResult = sqlSession.update(statement,user);

        sqlSession.close();
        System.out.println(retResult);
    }



    @Test
    public void testDelete(){
        SqlSession sqlSession = MybatisUtil.getSqlSession(true);

        String statement = "mybatis.mapper.userMapper.deleteUser";//映射sql的标识字符串

        int retResult = sqlSession.delete(statement,5);

        sqlSession.close();
        System.out.println(retResult);
    }

    @Test
    public void testGetAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        String statement = "mybatis.mapper.userMapper.getAllUsers";//映射sql的标识字符串

        List<User> lstUsers = sqlSession.selectList(statement);

        sqlSession.close();
        System.out.println(lstUsers);
    }


}
