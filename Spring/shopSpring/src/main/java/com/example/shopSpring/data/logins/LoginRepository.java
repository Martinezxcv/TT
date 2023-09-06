package com.example.shopSpring.data.logins;

import com.example.shopSpring.data.logins.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
}