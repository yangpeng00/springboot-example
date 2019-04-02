package com.example.mybatisdatasource.mapper.test2;

import com.example.mybatisdatasource.model.test2.News2;

public interface News2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News2 record);

    int insertSelective(News2 record);

    News2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News2 record);

    int updateByPrimaryKeyWithBLOBs(News2 record);

    int updateByPrimaryKey(News2 record);
}