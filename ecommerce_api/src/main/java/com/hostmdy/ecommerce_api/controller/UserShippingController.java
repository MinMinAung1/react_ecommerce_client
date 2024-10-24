package com.hostmdy.ecommerce_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.ecommerce_api.domain.UserShipping;
import com.hostmdy.ecommerce_api.service.UserShippingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("usershipping")
public class UserShippingController {
	
	private final UserShippingService userShippingService;
	
	@GetMapping("/all")
	public ResponseEntity<List<UserShipping>> getAllUserShipping(){
		List<UserShipping> userShippingList = userShippingService.getAllUserShipping();
		
		if(userShippingList.isEmpty()) {
			return ResponseEntity.status(404).build();
		}
		return new ResponseEntity<List<UserShipping>>(userShippingList,HttpStatus.OK);
	}
	
	@GetMapping("/{userShippingId}")
	public ResponseEntity<UserShipping> getUserShippingById(@PathVariable Long userShippingId){
		Optional<UserShipping> userShippingOptional = userShippingService.getUserShippingById(userShippingId);
		
		if(userShippingOptional.isEmpty()) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(userShippingOptional.get());
	}
	
	@PostMapping("create")
	public ResponseEntity<UserShipping> createUserShipping(@RequestBody UserShipping userShipping){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userShippingService.saveUserShipping(userShipping));
		
	}
	
	@PutMapping("update")
	public ResponseEntity<UserShipping> updateUserShipping(@RequestBody UserShipping userShipping){
		
		if(userShipping.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(userShippingService.saveUserShipping(userShipping));
	}
	
	@DeleteMapping("/{userShippingId}/delete")
	public ResponseEntity<Long> deleteUserShipping(@PathVariable Long userShippingId){
		
		if(userShippingService.getUserShippingById(userShippingId).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		userShippingService.deleteUserShippingById(userShippingId);
		
		return ResponseEntity.ok(userShippingId);
	}

}
