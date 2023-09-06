package com.example.shopSpring.data.products.model;

import com.example.shopSpring.data.carts.model.Cart;
import com.example.shopSpring.data.entities.Product_Order;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Product {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Product_Cart",
            joinColumns = {@JoinColumn(name = "Product_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "Cart_id")
            })
    List<Cart> carts;

    String name;
    Float price;
    int quantity;
    String description;

    @OneToMany(mappedBy = "product")
    List<Product_Order> productOrders;

}
