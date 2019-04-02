package com.example.springbootmybatis;

import com.alibaba.fastjson.JSON;
import com.example.springbootmybatis.mapper.AdminMapper;
import com.example.springbootmybatis.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	@Autowired
	AdminMapper adminMapper;
	@Test
	public void contextLoads() {
		Admin admin = adminMapper.selectByPrimaryKey(1);
		System.out.println(JSON.toJSONString(admin));
	}

}
