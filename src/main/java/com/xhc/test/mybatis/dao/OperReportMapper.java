package com.xhc.test.mybatis.dao;

import com.xhc.test.mybatis.entity.OperReport;

public interface OperReportMapper {
    int deleteByPrimaryKey(String serialNo);

    int insert(OperReport record);

    int insertSelective(OperReport record);

    OperReport selectByPrimaryKey(String serialNo);

    int updateByPrimaryKeySelective(OperReport record);

    int updateByPrimaryKey(OperReport record);
}