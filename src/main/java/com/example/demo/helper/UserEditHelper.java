package com.example.demo.helper;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Users;
import com.example.demo.form.UserEditForm;

@Component
public class UserEditHelper {
	 public UserEditForm toForm(Users user) {

	        UserEditForm form = new UserEditForm();

	        form.setId(user.getId());
	        form.setName(user.getName());
	        form.setBody(user.getBody());

	        return form;
	    }

	    /**
	     * 編集画面用FormをUsersに変換する
	     */
	    public Users toEntity(UserEditForm form) {

	        Users user = new Users();

	        user.setId(form.getId());
	        user.setName(form.getName());
	        user.setBody(form.getBody());

	        return user;
	    }
}
