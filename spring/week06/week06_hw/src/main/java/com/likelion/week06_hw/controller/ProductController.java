package com.likelion.week06_hw.controller;

import com.likelion.week06_hw.entity.Product;
import com.likelion.week06_hw.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) { return productService.saveProduct(product);}

    @GetMapping("/products")
    public List<Product> findProductAll() { return productService.findProductAll();}

    @GetMapping("/products/jpa")
    public List<Product> findByJPA() { return productService.findByJPA();}

    @GetMapping("/products/jpql")
    public List<Product> findByJPQL() { return productService.findByJPQL();}
}
