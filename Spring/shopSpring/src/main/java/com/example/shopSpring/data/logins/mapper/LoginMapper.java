package com.example.shopSpring.data.logins.mapper;

import com.example.shopSpring.data.logins.model.Login;
import com.example.shopSpring.data.logins.model.LoginDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    LoginDto toDto(Login source);
    List<LoginDto> toDtoList(List<Login> source);
    Login fromDto(LoginDto destination);
}
