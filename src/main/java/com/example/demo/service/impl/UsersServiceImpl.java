package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserMapper;
import com.example.demo.service.UsersService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService  {
	
    private final UserMapper userMapper;

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

	@Override
	public void deleteUser(long id) {
		userMapper.deleteById(id);
	}
	

}
