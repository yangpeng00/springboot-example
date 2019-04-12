package com.example.springbootmongoDB;

import com.alibaba.fastjson.JSON;
import com.example.springbootmongoDB.model.User;
import com.example.springbootmongoDB.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongoDbApplicationTests {

    @Autowired
    UserRepository userRepository;

	@Test
	public void contextLoads() {
        //final Logger logger = LoggerFactory.getLogger(getClass());

        //insert
        //User user = userRepository.save(new User(3l, "auuuu",23));
        //User user2 = userRepository.save(new User(4l, "uuuuu",23));
        //logger.info("创建用户成功 : [{}],[{}]", user, user2);

        //query
        //List<User> all = userRepository.findAll();

        //User user = userRepository.findById(1l);
        //System.out.println(JSON.toJSON(user));

        //logger.info("查询用户 : [{}]", Arrays.toString(all.toArray()));
        //删除用户
        userRepository.deleteById(2l);
	}

}
