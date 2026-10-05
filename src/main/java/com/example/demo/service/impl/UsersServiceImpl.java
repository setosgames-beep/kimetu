package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService  {
	
	@Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> getAllUsers() {
        return userMapper.findAll();
    }

    @Override
    public Users getUserById(long id) {
        return userMapper.findById(id);
    }

    @Override
    public void saveUser(Users user) {
        userMapper.insert(user);
    }

	
	

}
