package com.example.shopSpring.data.products.service;

import com.example.shopSpring.data.products.model.Product;
import com.example.shopSpring.data.products.model.ProductDto;

import java.util.List;

public interface ProductService {

     List<ProductDto> getAllProducts();
     void addProduct(ProductDto product);
}
