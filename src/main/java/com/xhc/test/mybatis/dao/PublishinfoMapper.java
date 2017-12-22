package com.xhc.test.mybatis.dao;

import com.xhc.test.mybatis.entity.Publishinfo;

public interface PublishinfoMapper {
    int deleteByPrimaryKey(String serialno);

    int insert(Publishinfo record);

    int insertSelective(Publishinfo record);

    Publishinfo selectByPrimaryKey(String serialno);

    int updateByPrimaryKeySelective(Publishinfo record);

    int updateByPrimaryKey(Publishinfo record);
}