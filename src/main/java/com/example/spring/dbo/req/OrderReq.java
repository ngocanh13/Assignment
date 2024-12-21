package com.example.spring.dbo.req;

import com.example.spring.entity.Product;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class OrderReq {
    private List<OrderItemReq> item;
    private Long id;
    private Double grandTotal;
    private Date createAt;
    private Long status;
    private String shippingAddress;
    private String telephone;
    private String cancelReason;


    private List<Product> products;

    public List<OrderItemReq> getItem() {
        return item;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
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

    public Long getStatus() {
        return status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public List<Product> getProducts() {
        return products;
    }
    public void setItem(List<OrderItemReq> item) {
        this.item = item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
