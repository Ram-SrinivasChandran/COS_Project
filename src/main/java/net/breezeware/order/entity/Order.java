package net.breezeware.order.entity;

/**
 * The `Order` class represents an order entity with various attributes such as
 * ID, user ID, total cost, contact information, order location, status, and
 * timestamps for order and delivery.
 */
public class Order {

    // Fields (Attributes)
    private int id;             // The unique identifier for the order.
    private int userId;         // The ID of the user who placed the order.
    private double totalCost;   // The total cost of the order.
    private String email;       // The email address associated with the order.
    private String phoneNumber; // The phone number associated with the order.
    private String location; // The location where the order should be delivered.
    private String status;      // The status of the order (e.g., pending, delivered).
    private String orderOn;     // The timestamp when the order was placed.
    private String deliveryOn;  // The timestamp when the order was delivered (if applicable).

    // Constructors...

    /**
     * Constructs an order with just the ID and user ID.
     */
    public Order(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    /**
     * Constructs an order with ID, user ID, total cost, and status.
     */
    public Order(int id, int userId, double totalCost, String status) {
        this.id = id;
        this.userId = userId;
        this.totalCost = totalCost;
        this.status = status;
    }

    /**
     * Constructs an order with detailed information including contact details and timestamps.
     */
    public Order(int id, int userId, double totalCost, String email, String phoneNumber,
                 String location, String status, String orderOn, String deliveryOn) {
        this.id = id;
        this.userId = userId;
        this.totalCost = totalCost;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.status = status;
        this.orderOn = orderOn;
        this.deliveryOn = deliveryOn;
    }

    // Getter and Setter methods for the fields...

    /**
     * Gets the unique identifier for the order.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the order.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the ID of the user who placed the order.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the ID of the user who placed the order.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets the total cost of the order.
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the total cost of the order.
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /**
     * Gets the email address associated with the order.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address associated with the order.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number associated with the order.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number associated with the order.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the location where the order should be delivered.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location where the order should be delivered.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets the status of the order.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the order.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the timestamp when the order was placed.
     */
    public String getOrderOn() {
        return orderOn;
    }

    /**
     * Sets the timestamp when the order was placed.
     */
    public void setOrderOn(String orderOn) {
        this.orderOn = orderOn;
    }

    /**
     * Gets the timestamp when the order was delivered (if applicable).
     */
    public String getDeliveryOn() {
        return deliveryOn;
    }

    /**
     * Sets the timestamp when the order was delivered (if applicable).
     */
    public void setDeliveryOn(String deliveryOn) {
        this.deliveryOn = deliveryOn;
    }
}
