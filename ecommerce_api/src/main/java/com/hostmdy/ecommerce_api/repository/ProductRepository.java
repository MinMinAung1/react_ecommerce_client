package com.hostmdy.ecommerce_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.ecommerce_api.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
