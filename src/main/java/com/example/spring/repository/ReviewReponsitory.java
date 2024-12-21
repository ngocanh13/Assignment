package com.example.spring.repository;

import com.example.spring.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewReponsitory extends JpaRepository<Review, Long> {
}
