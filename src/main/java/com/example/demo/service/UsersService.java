package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Users;
import com.example.demo.form.UserEditForm;


public interface UsersService {
	
	List<Users> getAllUsers();
	
    Users getUserById(long id);
    
    void saveUser(Users user);
	
    /** ユーザー一覧を取得（診断結果付き） */
    List<UserEditForm> getUserList();


    /** ユーザーを削除 */
void deleteUser(long id);
}
