package com.example.mybatisdatasource;

import com.example.mybatisdatasource.mapper.test1.NewsMapper;
import com.example.mybatisdatasource.mapper.test2.News2Mapper;
import com.example.mybatisdatasource.model.test1.News;
import com.example.mybatisdatasource.model.test2.News2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDatasourceApplicationTests {

    @Autowired
    NewsMapper newsMapper;
    @Autowired
    News2Mapper news2Mapper;
	@Test
	public void contextLoads() {

        News news = newsMapper.selectByPrimaryKey(1);
        News2 news2 = news2Mapper.selectByPrimaryKey(12);
        System.out.println(news.getContent());
        System.out.println(news2.getContent());

	}

}
