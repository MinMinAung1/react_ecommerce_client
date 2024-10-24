package com.hostmdy.ecommerce_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.ecommerce_api.domain.UserBilling;
import com.hostmdy.ecommerce_api.service.UserBillingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userBilling")
public class UserBillingController {
	
	private final UserBillingService userBillingService;
	
	@PostMapping("/create")
	public ResponseEntity<UserBilling> createUserBilling(@RequestBody UserBilling userBilling){
		
		return ResponseEntity.ok(userBillingService.saveUserBilling(userBilling));
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserBilling> updateUserBilling(@RequestBody UserBilling userBilling){
		if(userBilling.getId() == null) {
			ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(userBillingService.saveUserBilling(userBilling));
	}
	
	@DeleteMapping("/{userBillingId}/delete")
	public ResponseEntity<Long> deleteUserBilling(@PathVariable Long userBillingId){
		Optional<UserBilling> userBillingOpt = userBillingService.getUserBillingById(userBillingId);
		if(userBillingOpt.isEmpty()) {
			return ResponseEntity.status(404).build();
		}
		userBillingService.deleteUserBillingById(userBillingId);
		return ResponseEntity.ok(userBillingId);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserBilling>> getAllUserBilling(){
		List<UserBilling> userBillingList = userBillingService.getAllUserBilling();
		if(userBillingList.isEmpty()) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(userBillingList);
	}
	
	@GetMapping("/{userBillingId}")
	public ResponseEntity<UserBilling> getUserBillingById(@PathVariable Long userBillingId){
		Optional<UserBilling> userBillingOpt = userBillingService.getUserBillingById(userBillingId);
		if(userBillingOpt.isEmpty()) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(userBillingOpt.get());
	}

}
