package com.xhc.test.mybatis;

import com.xhc.test.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.InputStream;

/**
 * Created by mymac on 2017/11/28.
 */
public class Test1 {

    public static void main(String[] args) {
//        System.out.println(Test1.class.getResource("/").getPath());
//        System.out.println(Test1.class.getClassLoader().getResource(""));
//        System.out.println(System.getProperty("user.dir"));
        String basePath = System.getProperty("user.dir");
        String config = "conf.xml";

        InputStream is = Test1.class.getClassLoader().getResourceAsStream(config);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sessionFactory.openSession();

        String statement = "mybatis.mapper.userMapper.getUser";

        User user = sqlSession.selectOne(statement, 1);

        System.out.println(user);
    }
}
