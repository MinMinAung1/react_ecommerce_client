package com.hostmdy.ecommerce_api.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.ecommerce_api.domain.Review;
import com.hostmdy.ecommerce_api.repository.ReviewRepository;
import com.hostmdy.ecommerce_api.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
	
	private final ReviewRepository reviewRepository;

	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return (List<Review>) reviewRepository.findAll();
	}

	@Override
	public Optional<Review> getReviewById(Long reviewId) {
		// TODO Auto-generated method stub
		return reviewRepository.findById(reviewId);
	}

	@Override
	public Review saveReview(Review review) {
		// TODO Auto-generated method stub
		return reviewRepository.save(review);
	}

	@Override
	public void deleteReviewById(Long reviewId) {
		// TODO Auto-generated method stub
		reviewRepository.deleteById(reviewId);
	}

}
