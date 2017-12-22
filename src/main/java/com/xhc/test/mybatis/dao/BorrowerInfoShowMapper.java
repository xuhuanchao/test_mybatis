package com.xhc.test.mybatis.dao;

import com.xhc.test.mybatis.entity.BorrowerInfoShow;

public interface BorrowerInfoShowMapper {
    int deleteByPrimaryKey(String userid);

    int insert(BorrowerInfoShow record);

    int insertSelective(BorrowerInfoShow record);

    BorrowerInfoShow selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(BorrowerInfoShow record);

    int updateByPrimaryKey(BorrowerInfoShow record);
}