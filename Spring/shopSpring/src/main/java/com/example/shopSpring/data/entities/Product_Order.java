package com.example.shopSpring.data.entities;

import com.example.shopSpring.data.orders.model.Orders;
import com.example.shopSpring.data.products.model.Product;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
public class Product_Order {

    @EmbeddedId
    ProductOrderId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "Product_id")
    Product product;

    @OneToOne
    @JoinColumn(name = "Order_id", insertable = false, updatable = false)
    Orders order;

    float price;
    int quantity;
}
