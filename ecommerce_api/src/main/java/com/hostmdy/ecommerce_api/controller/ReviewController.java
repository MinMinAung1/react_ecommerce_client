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

import com.hostmdy.ecommerce_api.domain.Review;
import com.hostmdy.ecommerce_api.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
	
	private final ReviewService reviewService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Review>> getAllReviews(){
		List<Review> reviewList = reviewService.getAllReviews();
		if(reviewList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(reviewList);
	}
	
	@GetMapping("/{reviewId}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId){
		
		Optional<Review> reviewOptional = reviewService.getReviewById(reviewId);
		if(reviewOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(reviewOptional.get());
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Review> createReview(@RequestBody Review review){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.saveReview(review));
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Review> updateReview(@RequestBody Review review){
		
		if(review.getId()==null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(reviewService.saveReview(review));
		
	}
	
	@DeleteMapping("/{reviewId}/delete")
	public ResponseEntity<Long> deleteReview(@PathVariable Long reviewId){
		
		if(reviewService.getReviewById(reviewId).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		reviewService.deleteReviewById(reviewId);
		
		return ResponseEntity.ok(reviewId);
	}

}
