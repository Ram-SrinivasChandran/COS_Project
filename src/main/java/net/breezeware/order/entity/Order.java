package net.breezeware.order.entity;
public class Order {
    private int id;
    private int userId;
    private double totalCost;
    private String email;
    private String phoneNumber;
    private String orderLocation;
    private String status;
    private String orderOn;
    private String deliveryOn;

    public Order(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public Order(int id, int userId, double totalCost, String status) {
        this.id = id;
        this.userId = userId;
        this.totalCost = totalCost;
        this.status = status;
    }

    public Order(int id, int userId, double totalCost, String email, String phoneNumber, String orderLocation, String status, String orderOn, String deliveryOn) {
        this.id = id;
        this.userId = userId;
        this.totalCost = totalCost;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderLocation = orderLocation;
        this.status = status;
        this.orderOn = orderOn;
        this.deliveryOn = deliveryOn;
    }

    public Order(String email, String phoneNumber, String orderLocation) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderLocation = orderLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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

    public String getOrderOn() {
        return orderOn;
    }

    public void setOrderOn(String orderOn) {
        this.orderOn = orderOn;
    }

    public String getDeliveryOn() {
        return deliveryOn;
    }


    public void setDeliveryOn(String deliveryOn) {
        this.deliveryOn = deliveryOn;
    }
}
