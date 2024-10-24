package com.hostmdy.ecommerce_api.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.ecommerce_api.domain.UserShipping;

public interface UserShippingService {
	
	Optional<UserShipping> getUserShippingById(Long userShippingId);
	
	List<UserShipping> getAllUserShipping();
	
	UserShipping saveUserShipping(UserShipping userShipping);
	
	void deleteUserShippingById(Long userShipping);

}
