package com.example.springbootmongoDB.repository.impl;

import com.example.springbootmongoDB.model.User;
import com.example.springbootmongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public <S extends User> S save(S s) {
        return mongoTemplate.save(s);
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public User findById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        return mongoTemplate.findById(query,User.class);
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public Iterable<User> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
    }

    @Override
    public void delete(User user) {
        mongoTemplate.dropCollection(user.getClass());
    }

    @Override
    public void deleteAll() {

    }
}
