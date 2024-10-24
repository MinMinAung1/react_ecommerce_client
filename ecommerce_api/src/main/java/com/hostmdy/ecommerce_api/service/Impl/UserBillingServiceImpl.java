package com.hostmdy.ecommerce_api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.ecommerce_api.domain.UserBilling;
import com.hostmdy.ecommerce_api.repository.UserBillingRepository;
import com.hostmdy.ecommerce_api.service.UserBillingService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserBillingServiceImpl implements UserBillingService{
	
	private final UserBillingRepository userBillingRepository;

	@Override
	public UserBilling saveUserBilling(UserBilling userBilling) {
		// TODO Auto-generated method stub
		return userBillingRepository.save(userBilling);
	}

	@Override
	public Optional<UserBilling> getUserBillingById(Long userBillingId) {
		// TODO Auto-generated method stub
		return userBillingRepository.findById(userBillingId);
	}

	@Override
	public void deleteUserBillingById(Long userBillingId) {
		// TODO Auto-generated method stub
		userBillingRepository.deleteById(userBillingId);
	}

	@Override
	public List<UserBilling> getAllUserBilling() {
		// TODO Auto-generated method stub
		return (List<UserBilling>) userBillingRepository.findAll();
	}

}
