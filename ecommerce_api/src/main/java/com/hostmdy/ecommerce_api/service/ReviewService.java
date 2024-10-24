package com.hostmdy.ecommerce_api.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.ecommerce_api.domain.Review;

public interface ReviewService {
	
	List<Review> getAllReviews();
	
	Optional<Review> getReviewById(Long reviewId);
	
	Review saveReview(Review review);
	
	void deleteReviewById(Long reviewId);

}
