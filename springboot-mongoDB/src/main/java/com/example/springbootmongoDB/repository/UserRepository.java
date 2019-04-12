package com.example.springbootmongoDB.repository;

import com.example.springbootmongoDB.model.User;
import java.util.List;

public interface UserRepository {
    //保存对象
    public <S extends User> S save(S s);
    //批量保存对象
    public <S extends User> List<S> saveAll(Iterable<S> iterable) ;
    //根据id查找
    public User findById(Long id) ;
    //查找所有
    public List<User> findAll() ;
    //批量查询
    public Iterable<User> findAllById(Iterable<Integer> iterable);
    //根据id 删除
    public void deleteById(Long id);
    //根据对象删除
    public void delete(User user);
    //删除所有
    public void deleteAll();
}