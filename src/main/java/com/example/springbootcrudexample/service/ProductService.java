package com.example.springbootcrudexample.service;


import java.util.List;

import com.example.springbootcrudexample.DTO.ProductDTO;
import com.example.springbootcrudexample.entity.UserInfo;

public interface ProductService{


    String addUser(UserInfo userInfo);
    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> createProducts(List<ProductDTO> productDTOS);

    List<ProductDTO> getAllProducts();

	ProductDTO getProductById(int id);

	ProductDTO getProductByName(String name);

	ProductDTO updateProduct(ProductDTO product);

	String deleteProduct(int id);

}
