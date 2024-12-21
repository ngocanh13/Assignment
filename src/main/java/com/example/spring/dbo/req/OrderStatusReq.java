package com.example.spring.dbo.req;

public class OrderStatusReq {
    private Long orderId;
    private String status;
    private String cancelReason;

    public Long getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
