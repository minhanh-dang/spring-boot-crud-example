package com.example.springbootcrudexample.service;


import java.util.List;

import com.example.springbootcrudexample.model.DTO.ProductDTO;
import com.example.springbootcrudexample.model.entity.User;

public interface ProductService{


    String addUser(User userInfo);
    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> createProducts(List<ProductDTO> productDTOS);

    List<ProductDTO> getAllProducts();

	ProductDTO getProductById(int id);

	ProductDTO getProductByName(String name);

	ProductDTO updateProduct(ProductDTO product);

	String deleteProduct(int id);

}
