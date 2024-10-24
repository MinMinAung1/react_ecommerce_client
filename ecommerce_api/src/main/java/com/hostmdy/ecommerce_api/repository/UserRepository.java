package com.hostmdy.ecommerce_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.ecommerce_api.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
