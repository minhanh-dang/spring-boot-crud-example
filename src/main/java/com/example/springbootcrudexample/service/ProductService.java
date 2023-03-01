package com.example.springbootcrudexample.service;

import java.util.List;

import com.example.springbootcrudexample.DTO.ProductDTO;

public interface ProductService {
	ProductDTO createProduct(ProductDTO productDTO);

	List<ProductDTO> getAllProducts();

	ProductDTO getProductById(int id);

	ProductDTO getProductByName(String name);

	ProductDTO updateProduct(ProductDTO product);

	String deleteProduct(int id);

//    List<ProductDTO> findAll();
//    List<ProductDTO> getAllProducts
}
