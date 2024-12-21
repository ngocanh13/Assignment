package com.example.spring.repository;

import com.example.spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT SUM(o.grandTotal) FROM Order o WHERE o.status = 'Completed'")
    Double getTotalRevenue();
}
