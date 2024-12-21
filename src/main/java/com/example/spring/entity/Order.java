package com.example.spring.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "grand_total")
    private Double grandTotal;
    @Column(name = "created_at")
    private Date createAt;
    private  String status;
    @Column(name = "shipping_address")
    private String shippingAddress;
    private String telephone;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items;

    private String cancelReason;
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "order_items",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;

    public List<OrderItem> getItems() {
        return items;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public Date getCreateAt() {
        return createAt;
    }


    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getTelephone() {
        return telephone;
    }

//    public List<Product> getProducts() {
//        return products;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }


    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
}