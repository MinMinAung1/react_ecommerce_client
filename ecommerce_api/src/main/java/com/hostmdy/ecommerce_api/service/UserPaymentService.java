package com.hostmdy.ecommerce_api.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.ecommerce_api.domain.UserPayment;

public interface UserPaymentService {
	
	List<UserPayment> getAllUserPayments();
	Optional<UserPayment> getUserPaymentById(Long userPaymentId);
	UserPayment saveUserPayment(UserPayment userPayment);
	void deleteUserPaymentById(Long userPaymentId);

}
