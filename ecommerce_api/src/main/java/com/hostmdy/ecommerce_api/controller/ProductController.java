package com.hostmdy.ecommerce_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.ecommerce_api.domain.Product;
import com.hostmdy.ecommerce_api.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
//@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001"})
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	private final ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>>  getAllProduct(){
		List<Product> productList = productService.getAllProducts();
		
		if(productList.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
		
		Optional<Product> productOptional = productService.getProductById(productId);
		
		if(productOptional.isEmpty()) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(productOptional.get());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		
		if(product.getId() == null) {
			return ResponseEntity.badRequest().build();//badRequest is 400
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(productService.saveProduct(product));
	}
	
	@DeleteMapping("/{productId}/delete")
	public ResponseEntity<Long> deleteProduct(@PathVariable Long productId){
		
		if(productService.getProductById(productId).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		productService.deleteProductById(productId);
		
		return ResponseEntity.ok(productId);
	}
}
