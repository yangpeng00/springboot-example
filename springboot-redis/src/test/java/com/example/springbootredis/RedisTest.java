package com.example.springbootredis;

import com.example.springbootredis.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    CountDownLatch latch;
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void mapTest() {

        Map<String, String> map = new HashMap<>();
        map.put("1", "2xdfsdf");
        map.put("q", "w333333333wwwwwwwww");
        redisUtil.hashPutAll("map", map);
        //设置失效时间
        //redisUtil.setExpireAt("userRuleMap",new Date(System.currentTimeMillis()+30*60*1000));
        String s = redisUtil.hashGet("map", "q");
        System.out.println(s);
    }

    @Test
    public void redisMqTest() {
        //线程数不要超过连接池最大连接数
        //for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        redisTemplate.convertAndSend("queue",
                                Thread.currentThread().getName() + "-Hello from Redis你好!");
                    }
                }
            }.start();

        //}
        try {
            latch.await();
        } catch (Exception e) {
        }
    }

}