package com.example.spring.controller;

import com.example.spring.dbo.req.ReviewReq;
import com.example.spring.entity.Review;
import com.example.spring.repository.ReviewReponsitory;
import com.example.spring.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController( ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewReq reviewReq) {
        try {
            // Gọi service để tạo review
            Review review = reviewService.createReview(reviewReq);

            // Trả về ResponseEntity với đối tượng review nếu thành công
            return ResponseEntity.ok(review);
        } catch (RuntimeException e) {
            // Xử lý lỗi nếu không tìm thấy đơn hàng hoặc có lỗi xảy ra
            return ResponseEntity.badRequest().body(null);

        }
    }
}
