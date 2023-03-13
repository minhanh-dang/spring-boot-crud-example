package com.example.springbootcrudexample.controller;

import com.example.springbootcrudexample.DTO.ProductDTO;
import com.example.springbootcrudexample.entity.UserInfo;
import com.example.springbootcrudexample.service.JwtService;
import com.example.springbootcrudexample.service.ProductService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




// Marks the class as a controller where every method returns a domain object instead of a view
// It is shorthand for including both @Controller and @ResponseBody
@RestController
@AllArgsConstructor
public class ProductController {


    @Autowired
    private ProductService service;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/addUser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }
    @PostMapping("/addProduct")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product){
        ProductDTO savedProduct = service.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PostMapping("/addProducts")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity <List<ProductDTO>> addProducts(@RequestBody List<ProductDTO> products){
        List<ProductDTO> savedProducts = service.createProducts(products);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> products = service.getAllProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @GetMapping("/productById/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id){
        ProductDTO product = service.getProductById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/productByName/{name}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<ProductDTO> findProductByName(@PathVariable String name){
        ProductDTO product = service.getProductByName(name);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @PutMapping("/updateProduct")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO){
        ProductDTO updatedProduct = service.updateProduct(productDTO);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping ("/deleteProduct/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return new ResponseEntity<>("Product successfully deleted!",HttpStatus.OK);
    }

}
