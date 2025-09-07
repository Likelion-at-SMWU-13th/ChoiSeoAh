package com.likelion.week06_hw.repository;

import com.likelion.week06_hw.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    // JPA
    List<Product> findTop10ByOrderByPriceDesc(String name, int price);

    // JPQL
    @Query("SELECT p FROM Product p WHERE p.price <= 2000 ORDER BY p.stock DESC ")
    List<Product> findTop5ByOrderByStockDesc();
}
