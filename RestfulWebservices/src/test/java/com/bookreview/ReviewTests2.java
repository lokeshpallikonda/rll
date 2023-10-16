package com.bookreview;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.bookreview.controllers.ReviewController;
import com.bookreview.entity.Review;
import com.bookreview.service.ReviewService;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class ReviewTests2 {

    @Test
    public void testGetAllReviews() {
        // Mock ReviewService
        ReviewService mockReviewService = new ReviewService() {
            @Override
            public List<Review> getAllreview() {
                return Collections.emptyList(); // return an empty list
            }
        };

        // Instantiate ReviewController with mock ReviewService
        ReviewController reviewController = new ReviewController(mockReviewService);

        // Test
        assertNotNull(reviewController.getAll(), "Review list should not be null");
    }
}