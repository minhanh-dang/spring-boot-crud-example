package com.example.springbootcrudexample.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootcrudexample.DTO.ProductDTO;
import com.example.springbootcrudexample.entity.Product;
import com.example.springbootcrudexample.mapper.ProductMapper;
import com.example.springbootcrudexample.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	//////// POST method////////////

	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		Product product = ProductMapper.getInstance().toEntity(productDTO);
		return ProductMapper.getInstance().toDTO(productRepository.save(product));
	}

//	public List<ProductDTO> createProducts(List<ProductDTO> productsDTO) {
//		List<Product> products = productsDTO.stream().map(p -> ProductMapper.getInstance().toEntity(p))
//				.collect(Collectors.toList());
//		List<ProductDTO> productDtoList = products.stream().map(p->ProductMapper.getInstance().toDTO(productRepository.save(p))).collect(Collectors.toList());
//		//return ProductMapper.getInstance().toDTO(productRepository.save(products));
//		return productDtoList;
//	}
//}
//    public List<Product> saveProducts(List<Product> products) {
//        return productRepository.saveAll(products);
//    }

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
