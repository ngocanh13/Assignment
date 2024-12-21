package com.example.spring.dbo.req;

public class OrderItemReq {
    private  Long productId;

    private Long qty;

    public Long getProductId() {
        return productId;
    }

    public Long getQty() {
        return qty;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }
}
