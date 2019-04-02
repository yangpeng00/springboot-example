package com.example.springbootredis.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @author yp
 * @Date 2019/3/28
 */
public class RedisRecieve {

    private static final Logger logger = LoggerFactory.getLogger(RedisRecieve.class);

    private CountDownLatch latch;

    @Autowired
    public RedisRecieve(CountDownLatch latch) {
        this.latch = latch;
    }

    /**
     * 接收方法
     * @param message
     */
    public void receiveMessage(String message) {
        //logger.info("Received :" + message );
        System.out.println("Received :" + message);
        latch.countDown();
    }

}
