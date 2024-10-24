package com.hostmdy.ecommerce_api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.ecommerce_api.domain.UserShipping;
import com.hostmdy.ecommerce_api.repository.UserShippingRepository;
import com.hostmdy.ecommerce_api.service.UserShippingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserShippingServiceImpl implements UserShippingService{
	
	private final UserShippingRepository userShippingRepository;

	@Override
	public Optional<UserShipping> getUserShippingById(Long userShippingId) {
		// TODO Auto-generated method stub
		return userShippingRepository.findById(userShippingId);
	}

	@Override
	public List<UserShipping> getAllUserShipping() {
		// TODO Auto-generated method stub
		return (List<UserShipping>) userShippingRepository.findAll();
	}

	@Override
	public UserShipping saveUserShipping(UserShipping userShipping) {
		// TODO Auto-generated method stub
		return userShippingRepository.save(userShipping);
	}

	@Override
	public void deleteUserShippingById(Long userShipping) {
		// TODO Auto-generated method stub
		userShippingRepository.deleteById(userShipping);		
	}

}
