package com.example.shopSpring.data.logins.service;

import com.example.shopSpring.data.logins.model.Login;
import com.example.shopSpring.data.logins.model.LoginDto;

import java.util.List;

public interface LoginService {

     List<LoginDto> getAllLogins();
     void addLogin(LoginDto login);
}
