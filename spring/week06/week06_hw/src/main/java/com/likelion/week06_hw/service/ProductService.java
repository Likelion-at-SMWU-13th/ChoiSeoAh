package com.likelion.week06_hw.service;


import com.likelion.week06_hw.entity.Product;
import com.likelion.week06_hw.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findByJPA(String name, int price) {return productRepository.findTop10ByOrderByPriceDesc(name,price);}
    public List<Product> findByJPQL(String name, int price) { return productRepository.findTop10ByOrderByPriceDesc(name, price); }
}
