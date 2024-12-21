package com.example.spring.dbo.res;

import com.example.spring.entity.Order;
import com.example.spring.entity.Product;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class OrderRes {
    private Long id;
    private Double grandTotal;
    private Date createAt;
    private Long status;
    private String shippingAddress;
    private String telephone;


    private List<Product> products;


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
