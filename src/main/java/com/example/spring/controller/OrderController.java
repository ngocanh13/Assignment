package com.example.spring.controller;

import com.example.spring.dbo.req.OrderReq;
import com.example.spring.dbo.req.OrderStatusReq;
import com.example.spring.dbo.res.OrderRes;
import com.example.spring.entity.Order;
import com.example.spring.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/order")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @PostMapping
    public ResponseEntity<Order> checkout(@RequestBody OrderReq order){
        return ResponseEntity.ok(orderService.createOrder(order));
    }


    @PutMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestBody OrderStatusReq orderStatusReq
    ) {
        try {
            boolean isUpdated = orderService.updateOrderStatus(orderId, orderStatusReq.getStatus(), orderStatusReq.getCancelReason());

            if (isUpdated) {
                return ResponseEntity.ok("Order status updated successfully.");
            } else {
                return ResponseEntity.badRequest().body("Failed to update order status.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }


    @GetMapping("/total-revenue")
    public ResponseEntity<?> getTotalRevenue() {
        try {
            Double totalRevenue = orderService.getTotalRevenue();
            if (totalRevenue == null) {
                return ResponseEntity.ok(0.0);
            }
            return ResponseEntity.ok(totalRevenue);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}
