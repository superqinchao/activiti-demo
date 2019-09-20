package com.example.lambda.generator.mapper;

import com.example.lambda.generator.pojo.HiTaskinst;
import org.apache.ibatis.annotations.Mapper;

/**
* Created by Mybatis Generator on 2019/09/17
*/
public interface HiTaskinstMapper {
    int deleteByPrimaryKey(String id);

    int insert(HiTaskinst record);

    int insertSelective(HiTaskinst record);

    HiTaskinst selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HiTaskinst record);

    int updateByPrimaryKey(HiTaskinst record);
}