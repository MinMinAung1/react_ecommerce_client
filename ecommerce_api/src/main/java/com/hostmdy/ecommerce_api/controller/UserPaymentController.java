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

import com.hostmdy.ecommerce_api.domain.UserPayment;
import com.hostmdy.ecommerce_api.service.UserPaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userpayment")
public class UserPaymentController {

	private final UserPaymentService userPaymentService;

	@GetMapping("/all")
	public ResponseEntity<List<UserPayment>> getAllUserPayments() {
		List<UserPayment> userPaymentList = userPaymentService.getAllUserPayments();
		if (userPaymentList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userPaymentList);
	}

	@GetMapping("/{userPaymentId}")
	public ResponseEntity<UserPayment> getUserPaymentById(@PathVariable Long userPaymentId) {
		Optional<UserPayment> userPaymentOptional = userPaymentService.getUserPaymentById(userPaymentId);
		if (userPaymentOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userPaymentOptional.get());
	}

	@PostMapping("/create")
	public ResponseEntity<UserPayment> createUserPayment(@RequestBody UserPayment userPayment) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userPaymentService.saveUserPayment(userPayment));
	}

	@PutMapping("/update")
	public ResponseEntity<UserPayment> updateUserPayment(@RequestBody UserPayment userPayment) {
		if (userPayment.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(userPaymentService.saveUserPayment(userPayment));
	}

	@DeleteMapping("/{userPaymentId}/delete")
	public ResponseEntity<Long> deleteUserPaymentById(@PathVariable Long userPaymentId) {
		if (userPaymentService.getUserPaymentById(userPaymentId).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		userPaymentService.deleteUserPaymentById(userPaymentId);
		return ResponseEntity.ok(userPaymentId);
	}

}
