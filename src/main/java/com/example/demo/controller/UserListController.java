package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.UserEditForm;
import com.example.demo.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserListController {

    private final UsersService usersService;

    // GET /users → ユーザー一覧
    @GetMapping("/users")
    public String list(Model model) {
        List<UserEditForm> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        return "diagnosis/users";
    }

    // POST /users/{id}/delete → 削除して一覧に戻る
    @PostMapping("/users/{id}/delete")
    public String delete(@PathVariable long id) {
        usersService.deleteUser(id);
        return "redirect:/users";
    }
}