package com.example.spring.entity;

import jakarta.persistence.*;
import org.aspectj.apache.bcel.classfile.ConstantInterfaceMethodref;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private Long qty;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Long getQty() {
        return qty;
    }

    public Long getProductId() {
        return productId;
    }

    public Order getOrder() {
        return order;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
