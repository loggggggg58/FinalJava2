package com.samsung.finaljava2.controller;

import com.samsung.finaljava2.repository.model.User;
import com.samsung.finaljava2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String getRegisterPage() {
        return "registerPage";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "loginPage";
    }

    @PostMapping("/auth/register")
    public String register(@ModelAttribute User user) {
        userService.createUser(user);
        return "loginPage";
    }

}
