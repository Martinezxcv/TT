package com.example.shopSpring.data.products;

import com.example.shopSpring.data.products.mapper.ProductMapper;
import com.example.shopSpring.data.products.model.Product;
import com.example.shopSpring.data.products.model.ProductDto;
import com.example.shopSpring.data.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts() {
        return productMapper.toDtoList(productRepository.findAll());
    }

    @Override
    public void addProduct(ProductDto product) {
        productRepository.save(productMapper.fromDto(product));
    }
}
