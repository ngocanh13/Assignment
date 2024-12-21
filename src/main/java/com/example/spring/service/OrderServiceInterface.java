package com.example.spring.service;

public interface OrderServiceInterface {
    boolean updateOrderStatus(Long orderId, String status, String cancelReason);
}
