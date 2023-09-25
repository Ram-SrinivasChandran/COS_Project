package net.breezeware.order.entity;

import net.breezeware.user.entity.User;
import java.time.Instant;

/**
 * Represents an order with various attributes, including user information,
 * order details, and delivery information.
 */
public class Order {
    private int id;                 // Unique identifier for the order.
    private int userId;            // The user who placed the order.
    private double totalCost;       // The total cost of the order.
    private String email;           // Email associated with the order.
    private long phoneNumber;       // Phone number associated with the order.
    private String orderLocation;   // The location for the order delivery.
    private String status;          // The status of the order.
    private Instant orderOn;        // The timestamp when the order was placed.
    private Instant deliveryOn;     // The timestamp when the order will be delivered.

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

    public Order(String email, long phoneNumber, String orderLocation) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderLocation = orderLocation;
    }

    /**
     * Get the unique identifier of the order.
     *
     * @return The order's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the order.
     *
     * @param id The order's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the user who placed the order.
     *
     * @return The user who placed the order.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the user who placed the order.
     *
     * @param userId The user who placed the order.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the total cost of the order.
     *
     * @return The total cost of the order.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Set the total cost of the order.
     *
     * @param totalCost The total cost of the order.
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Get the email associated with the order.
     *
     * @return The email associated with the order.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email associated with the order.
     *
     * @param email The email associated with the order.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number associated with the order.
     *
     * @return The phone number associated with the order.
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number associated with the order.
     *
     * @param phoneNumber The phone number associated with the order.
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the location for the order delivery.
     *
     * @return The location for the order delivery.
     */
    public String getOrderLocation() {
        return orderLocation;
    }

    /**
     * Set the location for the order delivery.
     *
     * @param orderLocation The location for the order delivery.
     */
    public void setOrderLocation(String orderLocation) {
        this.orderLocation = orderLocation;
    }

    /**
     * Get the status of the order.
     *
     * @return The status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status of the order.
     *
     * @param status The status of the order.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get the timestamp when the order was placed.
     *
     * @return The timestamp when the order was placed.
     */
    public Instant getOrderOn() {
        return orderOn;
    }

    /**
     * Set the timestamp when the order was placed.
     *
     * @param orderOn The timestamp when the order was placed.
     */
    public void setOrderOn(Instant orderOn) {
        this.orderOn = orderOn;
    }

    /**
     * Get the timestamp when the order will be delivered.
     *
     * @return The timestamp when the order will be delivered.
     */
    public Instant getDeliveryOn() {
        return deliveryOn;
    }

    /**
     * Set the timestamp when the order will be delivered.
     *
     * @param deliveryOn The timestamp when the order will be delivered.
     */
    public void setDeliveryOn(Instant deliveryOn) {
        this.deliveryOn = deliveryOn;
    }
}
