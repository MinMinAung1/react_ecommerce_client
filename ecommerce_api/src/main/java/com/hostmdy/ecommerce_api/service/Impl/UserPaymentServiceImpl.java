package com.hostmdy.ecommerce_api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.ecommerce_api.domain.UserPayment;
import com.hostmdy.ecommerce_api.repository.UserPaymentRepository;
import com.hostmdy.ecommerce_api.service.UserPaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserPaymentServiceImpl implements UserPaymentService {
	
	private final UserPaymentRepository userPaymentRepository;

	@Override
	public List<UserPayment> getAllUserPayments() {
		// TODO Auto-generated method stub
		return (List<UserPayment>) userPaymentRepository.findAll();
	}

	@Override
	public Optional<UserPayment> getUserPaymentById(Long userPaymentId) {
		// TODO Auto-generated method stub
		return userPaymentRepository.findById(userPaymentId);
	}

	@Override
	public UserPayment saveUserPayment(UserPayment userPayment) {
		// TODO Auto-generated method stub
		return userPaymentRepository.save(userPayment);
	}

	@Override
	public void deleteUserPaymentById(Long userPaymentId) {
		// TODO Auto-generated method stub
		userPaymentRepository.deleteById(userPaymentId);
	}

}
