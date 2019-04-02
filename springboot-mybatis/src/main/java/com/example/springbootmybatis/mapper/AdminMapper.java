package com.example.springbootmybatis.mapper;

import com.example.springbootmybatis.model.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yp
 */
@Mapper
public interface AdminMapper {


    /**
     *根据id查找
     * @param id
     * @return
     */
    Admin selectByPrimaryKey(Integer id);

}