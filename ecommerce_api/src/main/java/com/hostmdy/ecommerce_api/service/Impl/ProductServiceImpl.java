package com.hostmdy.ecommerce_api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.ecommerce_api.domain.Product;
import com.hostmdy.ecommerce_api.repository.ProductRepository;
import com.hostmdy.ecommerce_api.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;

	@Override
	public Optional<Product> getProductById(Long productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public void deleteProductById(Long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
	}

}
