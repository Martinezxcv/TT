package com.example.shopSpring.data.logins.controller;

import com.example.shopSpring.data.logins.model.Login;
import com.example.shopSpring.data.logins.model.LoginDto;
import com.example.shopSpring.data.logins.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RequestMapping(path = "login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public @ResponseBody Iterable<LoginDto> getAllEmployees() {
        return loginService.getAllLogins();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping
    public String addEmployee(@RequestBody LoginDto login) {
        loginService.addLogin(login);
        return "Added";
    }
}
