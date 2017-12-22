package com.xhc.test.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by mymac on 2017/11/28.
 */
public class MybatisUtil {

    public static SqlSessionFactory getSqlSessionFactory() {
        String basePath = System.getProperty("user.dir");
        String config = "conf.xml";

        InputStream is = Test1.class.getClassLoader().getResourceAsStream(config);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        return sessionFactory;
    }

    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }

    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }
}
