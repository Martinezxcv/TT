package com.example.shopSpring.data.clients.model;

import com.example.shopSpring.data.addresses.model.Address;
import com.example.shopSpring.data.carts.model.Cart;
import com.example.shopSpring.data.logins.model.Login;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ClientDto {

    Integer id;
    Login loginId;
    Address address;
    Cart cartId;
    String firstname;
    String lastname;
    String phone;
    String email;
}
