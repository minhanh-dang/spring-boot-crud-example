package com.example.springbootcrudexample.controller;

import com.example.springbootcrudexample.DTO.ProductDTO;
import com.example.springbootcrudexample.entity.Product;
import com.example.springbootcrudexample.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marks the class as a controller where every method returns a domain object instead of a view
// It is shorthand for including both @Controller and @ResponseBody
@RestController
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService service;

//    @PostMapping("/addProduct")
//    public Product createProduct(@RequestBody Product product){
//        return service.createProduct(product);
//    }
    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product){
        ProductDTO savedProduct = service.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

//    @PostMapping("/addProducts")
//    public List<Product> addProducts(@RequestBody List<Product> products){
//        return service.saveProducts(products);
//    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> products = service.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
    @GetMapping("/productById/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id){
        ProductDTO product = service.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/productByName/{name}")
    public ResponseEntity<ProductDTO> findProductByName(@PathVariable String name){
        ProductDTO product = service.getProductByName(name);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO){
        ProductDTO updatedProduct = service.updateProduct(productDTO);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping ("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return new ResponseEntity<>("Product successfully deleted!",HttpStatus.OK);
    }
}
