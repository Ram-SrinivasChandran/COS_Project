package net.breezeware.order;

import net.breezeware.user.entity.User;

import java.time.Instant;

public class Order {
    private int id;
    private User userId;
    private double totalCost;
    private String email;
    private long phoneNumber;
    private String orderLocation;
    private String status;
    private Instant orderOn;
    private Instant deliveryOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrderLocation() {
        return orderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        this.orderLocation = orderLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getOrderOn() {
        return orderOn;
    }

    public void setOrderOn(Instant orderOn) {
        this.orderOn = orderOn;
    }

    public Instant getDeliveryOn() {
        return deliveryOn;
    }

    public void setDeliveryOn(Instant deliveryOn) {
        this.deliveryOn = deliveryOn;
    }
}
