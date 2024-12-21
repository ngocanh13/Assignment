package com.example.spring.service;

import com.example.spring.dbo.req.ReviewReq;
import com.example.spring.entity.Order;
import com.example.spring.entity.Review;
import com.example.spring.repository.OrderRepository;
import com.example.spring.repository.ReviewReponsitory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewReponsitory reviewReponsitory;
    private final OrderRepository orderRepository;

    public ReviewService( ReviewReponsitory reviewReponsitory, OrderRepository orderRepository) {
        this.reviewReponsitory = reviewReponsitory;
        this.orderRepository = orderRepository;
    }
    @Transactional
    public Review createReview(ReviewReq reviewReq) {

        Order order = orderRepository.findById(reviewReq.getOrder())
                .orElseThrow(() -> new RuntimeException("Order not found: " + reviewReq.getOrder()));


        Review review = new Review();
        review.setOrder(order);
        review.setRating(reviewReq.getRating());
        review.setComment(reviewReq.getComment());

        return reviewReponsitory.save(review);
    }

}
