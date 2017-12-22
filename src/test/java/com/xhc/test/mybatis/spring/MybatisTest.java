package com.xhc.test.mybatis.spring;

import com.xhc.test.mybatis.entity.User;
import com.xhc.test.mybatis.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by mymac on 2017/12/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration
        (locations={"/spring.xml","/spring-mybatis.xml"}) //加载配置文件
public class MybatisTest {

    @Autowired
    private IUserService userService;

    @Test
    public void test(){

//        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
//        //从Spring容器中根据bean的id取出我们要使用的userService对象
//        userService = (IUserService) ac.getBean("userService");
        User user = new User();
        user.setName("zhangsan");
        user.setAge(20);
        userService.addUser(user);

    }


}
