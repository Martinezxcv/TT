package com.example.shopSpring.data.employees.model;

import com.example.shopSpring.data.entities.Product_History;
import com.example.shopSpring.data.logins.model.Login;
import com.example.shopSpring.data.roles.model.Roles;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Employee {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "Login_id")
    Login loginId;

    @OneToOne
    @JoinColumn(name = "Role_id")
    Roles roleId;

    @OneToOne
    @JoinColumn(name = "ProductHistory_id")
    Product_History productHistoryId;

    String firstname;
    String lastname;
    String phone;
    String email;


}
