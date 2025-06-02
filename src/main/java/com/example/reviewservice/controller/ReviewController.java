package com.example.reviewservice.controller;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reviews")
@CrossOrigin(origins = "http://localhost:5173")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{bookId}")
    public List<Review> getReviewsByBookId(@PathVariable int bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    // Update all reviews for a bookId
    @PutMapping("/{bookId}")
    public List<Review> updateReviewsByBookId(@PathVariable int bookId, @RequestBody Review review) {
        return reviewService.updateReviewsByBookId(bookId, review);
    }

    // Delete all reviews for a bookId
    @DeleteMapping("/{bookId}")
    public void deleteReviewsByBookId(@PathVariable int bookId) {
        reviewService.deleteReviewsByBookId(bookId);
    }
}
