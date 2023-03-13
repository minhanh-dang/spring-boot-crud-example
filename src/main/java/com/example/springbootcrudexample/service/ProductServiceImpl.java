
package com.example.springbootcrudexample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springbootcrudexample.DTO.ProductDTO;
import com.example.springbootcrudexample.entity.Product;
import com.example.springbootcrudexample.entity.UserInfo;
import com.example.springbootcrudexample.mapper.ProductMapper;
import com.example.springbootcrudexample.repository.ProductRepository;
import com.example.springbootcrudexample.repository.UserInfoRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserInfoRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	//////// POST method////////////
	@Override
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "User added";
	}

	//////// POST method////////////

	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = ProductMapper.getInstance().toEntity(productDTO);
		return ProductMapper.getInstance().toDTO(productRepository.save(product));
	}

//    public List<ProductDTO> createProducts(List<ProductDTO> productsDTO){
//        List<Product> products = ProductMapper.getInstance().toEntity(productsDTO);
//        return ProductMapper.getInstance().toDTO(productRepository.save(products));

	// public List<ProductDTO> createProducts(List<ProductDTO> productsDTO) {
//		List<Product> products = ProductMapper.getInstance().toEntity(productsDTO);
//		return ProductMapper.getInstance().toDTO(productRepository.save(products));
//	}
//}
//    public List<Product> saveProducts(List<Product> products) {
//        return productRepository.saveAll(products);
//    }
//}
	@Override
	public List<ProductDTO> createProducts(List<ProductDTO> productDTOS) {
		List<Product> products = productDTOS.stream().map(product -> ProductMapper.getInstance().toEntity(product))
				.collect(Collectors.toList());
		List<ProductDTO> productDTOList = products.stream()
				.map(product -> ProductMapper.getInstance().toDTO(productRepository.save(product)))
				.collect(Collectors.toList());
		return productDTOList;
//        List<Product> products = ProductMapper.getInstance().toEntity(productsDTO); ;
//        return productRepository.saveAll(products).stream()
//                .map(product -> ProductMapper.getInstance().toDTO(products))
//                .collect(Collectors.toList());
		// return
		// ProductMapper.getInstance().toDTO(productRepository.saveAll(productDTOS));
	}

	/////// GET method //////////

	@Override
	public List<ProductDTO> getAllProducts() {
		return productRepository.findAll().stream().map(product -> ProductMapper.getInstance().toDTO(product))
				.collect(Collectors.toList());
	}

	@Override
	public ProductDTO getProductById(int id) {
		Product product = productRepository.findById(id).get();
		return ProductMapper.getInstance().toDTO(product);
	}

	@Override
	public ProductDTO getProductByName(String name) {
		Product product = productRepository.findByName(name);
		return ProductMapper.getInstance().toDTO(product);
	}

	@Override
	public ProductDTO updateProduct(ProductDTO product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		Product updatedProduct = productRepository.save(existingProduct);
		return ProductMapper.getInstance().toDTO(updatedProduct);
	}

	@Override
	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Product removed: " + id;
	}
}
