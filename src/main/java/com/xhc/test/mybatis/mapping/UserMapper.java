package com.xhc.test.mybatis.mapping;

import com.xhc.test.mybatis.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by mymac on 2017/11/28.
 */
public interface UserMapper {

    @Insert("insert into users(name, age) values(#{name}, #{age})")
    public int add(User user);

    @Delete("delete from users where id=#{id}")
    public int deleteById(int id);

    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    public int update(User user);

    @Select("select * from users where id=#{id}")
    public User getById(int id);

    @Select("select * from users")
    public List<User> getAll();

}
