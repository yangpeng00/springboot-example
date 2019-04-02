package com.example.springbootmybatis.web;

import com.alibaba.fastjson.JSON;
import com.example.springbootmybatis.mapper.AdminMapper;
import com.example.springbootmybatis.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author yp
 * @Date 2019/4/2
 */
@RestController
public class HelloController {
    @Autowired
    AdminMapper adminMapper;

    @RequestMapping("/index")
    public String index() throws SQLException {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        System.out.println(JSON.toJSONString(admin));
        return JSON.toJSONString(admin);
    }
}
