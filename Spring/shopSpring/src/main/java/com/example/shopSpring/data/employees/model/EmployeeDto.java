package com.example.shopSpring.data.employees.model;

import com.example.shopSpring.data.entities.Product_History;
import com.example.shopSpring.data.logins.model.Login;
import com.example.shopSpring.data.roles.model.Roles;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    Integer id;
    Login loginId;
    Roles roleId;
    Product_History productHistoryId;
    String firstname;
    String lastname;
    String phone;
    String email;
}
