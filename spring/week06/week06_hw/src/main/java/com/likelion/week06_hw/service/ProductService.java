package com.likelion.week06_hw.service;


import com.likelion.week06_hw.entity.Product;
import com.likelion.week06_hw.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product saveProduct(Product product) { return productRepository.save(product); }

    public List<Product> findProductAll() { return productRepository.findAll();}

    // JPA
    public List<Product> findByJPA() {return productRepository.findTop10ByOrderByPriceDesc();}

    // JPQL
    public List<Product> findByJPQL() { return productRepository.findTop5ByOrderByStockDesc(PageRequest.of(0,5)); }
}
