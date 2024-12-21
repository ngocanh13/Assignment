package com.example.spring.service;

import com.example.spring.dbo.req.OrderReq;
import com.example.spring.dbo.res.OrderRes;
import com.example.spring.entity.Order;
import com.example.spring.entity.OrderItem;
import com.example.spring.entity.Product;
import com.example.spring.mapper.OrderMapper;
import com.example.spring.repository.OrderRepository;
import com.example.spring.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class OrderService implements OrderServiceInterface {


    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {

        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }



    @Transactional
    public Order createOrder(OrderReq orderReq){
        Order order = new Order();
        order.setGrandTotal(0.0);
        List<OrderItem> items = orderReq.getItem().stream().map(
                item-> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProductId(item.getProductId());
                    orderItem.setQty(item.getQty());
                    Product p = productRepository.findById(item.getProductId()).orElseThrow(
                            ()-> new RuntimeException("Product not found: "+item.getProductId())
                    );
                    if(p.getQty() < item.getQty())
                        throw new RuntimeException("Insufficient stock for product: "+p.getName());
                    p.setQty(p.getQty() - item.getQty());
                    productRepository.save(p);
                    orderItem.setPrice(p.getPrice());
                    orderItem.setOrder(order);
                    order.setGrandTotal(order.getGrandTotal() + orderItem.getQty() * p.getPrice());
                    return orderItem;
                }
        ).toList();
        order.setItems(items);
        order.setCreateAt(new Date());
        order.setShippingAddress(orderReq.getShippingAddress());
        order.setTelephone(orderReq.getTelephone());
        return orderRepository.save(order);
    }


    @Transactional
    public boolean updateOrderStatus(Long orderId, String status, String cancelReason) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));

        if ("Cancelled".equalsIgnoreCase(status)) {
            if (cancelReason == null || cancelReason.isBlank()) {
                throw new IllegalArgumentException("Cancel reason is required for cancelling an order.");
            }
            order.setStatus("Cancelled");
            order.setCancelReason(cancelReason);
        } else {
            order.setStatus(status);
            order.setCancelReason(null);
        }

        orderRepository.save(order);
        return true;
    }


    public Double getTotalRevenue() {
        return orderRepository.findAll()
                .stream()
                .filter(order -> !"Cancelled".equalsIgnoreCase(order.getStatus())) // Bỏ qua đơn hủy
                .mapToDouble(Order::getGrandTotal)
                .sum();
    }
}