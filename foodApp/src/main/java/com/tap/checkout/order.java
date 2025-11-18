package com.tap.checkout;

import java.sql.Timestamp;
import java.util.*;

public class order {
    private int orderId;
    private int userId;
    private int restId;
    private Timestamp orderDate;
    private double totalAmount;
    private String status;
    private String paymentMethod;
    private List<order> orderItems;

    public order() {
        this.orderDate = new Timestamp(System.currentTimeMillis());
        this.orderItems = new ArrayList<>();
    }

    public order(int orderId, int userId, int restId, Timestamp orderDate, double totalAmount, String status, String paymentMethod) {
        this.orderId = orderId;
        this.userId = userId;
        this.restId = restId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.orderItems = new ArrayList<>();
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getRestId() { return restId; }
    public void setRestId(int restId) { this.restId = restId; }

    public Timestamp getOrderDate() { return orderDate; }
    public void setOrderDate(Timestamp orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public List<order> getOrderItems() { return orderItems; }
    public void setOrderItems(List<order> orderItems) { this.orderItems = orderItems; }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", userId=" + userId + ", restId=" + restId +
               ", orderDate=" + orderDate + ", totalAmount=" + totalAmount +
               ", status=" + status + ", paymentMethod=" + paymentMethod + "]";
    }
}