package com.example.ecomercegamesmobile.src.repository;

import com.example.ecomercegamesmobile.src.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
