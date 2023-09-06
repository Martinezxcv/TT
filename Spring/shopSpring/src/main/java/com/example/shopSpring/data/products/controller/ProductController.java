package com.example.shopSpring.data.products.controller;
import com.example.shopSpring.data.products.model.Product;
import com.example.shopSpring.data.products.model.ProductDto;
import com.example.shopSpring.data.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public @ResponseBody Iterable<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public String addProduct(@RequestBody ProductDto product) {
        productService.addProduct(product);
        return "Added";
    }
}
