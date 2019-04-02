package com.example.springbootredis.util;

import com.example.springbootredis.mq.RedisRecieve;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * @author yp
 * @Date 2019/3/28
 */
@Configuration
public class RedisMqConfig {
    @Bean
    RedisRecieve receiver(CountDownLatch latch) {
        return new RedisRecieve(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

//    @Bean
//    RedisTemplate template(RedisConnectionFactory connectionFactory) {
//        return new StringRedisTemplate(connectionFactory);
//    }


    /**
     * 添加主题监听
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("queue"));
        return container;
    }

    /**
     * 监听适配器，并指定监听类执行的方法
     * @param receiver
     * @return
     */
    @Bean
    MessageListenerAdapter listenerAdapter(RedisRecieve receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
