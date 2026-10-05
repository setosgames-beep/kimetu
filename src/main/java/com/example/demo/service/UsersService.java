package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Users;


public interface UsersService {
	
	List<Users> getAllUsers();

    Users getUserById(long id);

    void saveUser(Users user);

}
