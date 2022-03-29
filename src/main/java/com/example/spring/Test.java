package com.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test {
    @Autowired private Repository repositoryTest;
    public List<UserEntity> Out(){
        return (List<UserEntity>) repositoryTest.findAll();
    }
    public void add(UserEntity User){
        repositoryTest.save(User);
    }
    public void delete(UserEntity User){
        repositoryTest.delete(User);
    }
}
