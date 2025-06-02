package com.example.reviewservice.service;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get all reviews for a specific book
    public List<Review> getReviewsByBookId(int bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    // Create a new review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Update all reviews for a bookId
    public List<Review> updateReviewsByBookId(int bookId, Review reviewDetails) {
        List<Review> reviews = reviewRepository.findByBookId(bookId);
        if (reviews.isEmpty()) {
            throw new RuntimeException("No reviews found for bookId " + bookId);
        }

        for (Review review : reviews) {
            review.setAuthor(reviewDetails.getAuthor());
            review.setSubject(reviewDetails.getSubject());
            review.setContent(reviewDetails.getContent());
        }

        return reviewRepository.saveAll(reviews);
    }

    // Delete all reviews for a specific bookId
    public void deleteReviewsByBookId(int bookId) {
        List<Review> reviews = reviewRepository.findByBookId(bookId);
        if (reviews.isEmpty()) {
            throw new RuntimeException("No reviews found to delete for bookId " + bookId);
        }
        reviewRepository.deleteAll(reviews);
    }
}
