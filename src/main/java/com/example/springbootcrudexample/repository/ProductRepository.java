package com.example.springbootcrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootcrudexample.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
