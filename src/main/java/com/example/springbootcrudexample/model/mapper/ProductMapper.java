package com.example.springbootcrudexample.model.mapper;

import com.example.springbootcrudexample.model.DTO.ProductDTO;
import com.example.springbootcrudexample.model.entity.Product;

public class ProductMapper {

    private static ProductMapper INSTANCE;

    public static ProductMapper getInstance(){
        if (INSTANCE == null){
            INSTANCE = new ProductMapper();
        }
        return  INSTANCE;
    }

    public Product toEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        return product;
    }

    public ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }
}
