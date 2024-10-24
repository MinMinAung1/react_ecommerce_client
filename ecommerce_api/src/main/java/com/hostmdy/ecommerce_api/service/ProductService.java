package com.hostmdy.ecommerce_api.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.ecommerce_api.domain.Product;

public interface ProductService {
	
	Optional<Product> getProductById(Long productId);
	
	List<Product> getAllProducts();
	
	Product saveProduct(Product product);
	
	void deleteProductById(Long productId);

}
