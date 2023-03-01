package com.example.springbootcrudexample.service;

import com.example.springbootcrudexample.DTO.ProductDTO;
import com.example.springbootcrudexample.entity.Product;
//import com.example.springbootcrudexample.entity.Product;
//import com.example.springbootcrudexample.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService{
    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(int id);

    ProductDTO getProductByName(String name);

    ProductDTO updateProduct(ProductDTO product);

    String deleteProduct(int id);

//    List<ProductDTO> findAll();
//    List<ProductDTO> getAllProducts
}
