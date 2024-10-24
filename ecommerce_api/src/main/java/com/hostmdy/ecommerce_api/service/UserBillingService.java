package com.hostmdy.ecommerce_api.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.ecommerce_api.domain.UserBilling;

public interface UserBillingService {
	
	UserBilling saveUserBilling(UserBilling userBilling);
	
	Optional<UserBilling> getUserBillingById(Long userBillingId);
	
	void deleteUserBillingById(Long userBillingId);

	List<UserBilling> getAllUserBilling();
	

}
