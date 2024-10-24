package com.hostmdy.ecommerce_api.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.ecommerce_api.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
