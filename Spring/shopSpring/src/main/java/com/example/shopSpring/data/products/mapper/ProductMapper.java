package com.example.shopSpring.data.products.mapper;

import com.example.shopSpring.data.products.model.Product;
import com.example.shopSpring.data.products.model.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product source);
    List<ProductDto> toDtoList(List<Product> source);
    Product fromDto(ProductDto destination);
}
