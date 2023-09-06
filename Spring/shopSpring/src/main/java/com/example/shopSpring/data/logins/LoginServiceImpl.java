package com.example.shopSpring.data.logins;

import com.example.shopSpring.data.logins.mapper.LoginMapper;
import com.example.shopSpring.data.logins.model.Login;
import com.example.shopSpring.data.logins.model.LoginDto;
import com.example.shopSpring.data.logins.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final LoginMapper loginMapper;

    @Override
    public List<LoginDto> getAllLogins() {
        return loginMapper.toDtoList(loginRepository.findAll());
    }

    @Override
    public void addLogin(LoginDto login) {
        loginRepository.save(loginMapper.fromDto(login));
    }

}
