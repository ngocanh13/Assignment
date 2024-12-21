package com.example.spring.dbo.req;

import com.example.spring.entity.Category;
import jakarta.persistence.JoinColumn;

public class ProductReq {
    private Long id;
    private String name;
    private Double price;
    private Long qty;
    private String description;

    private Category category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Long getQty() {
        return qty;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
