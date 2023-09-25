package net.breezeware.order.dto;

/**
 * The PlaceOrderDto class represents a data transfer object for placing an order.
 */
public class PlaceOrderDto {

    /**
     * The email associated with the order.
     */
    private String email;

    /**
     * The phone number associated with the order.
     */
    private String phoneNumber;

    /**
     * The order location where the order is to be delivered.
     */
    private String orderLocation;

    /**
     * Constructs a PlaceOrderDto with the specified email, phone number, and order location.
     *
     * @param email         The email associated with the order.
     * @param phoneNumber   The phone number associated with the order.
     * @param orderLocation The order location where the order is to be delivered.
     */
    public PlaceOrderDto(String email, String phoneNumber, String orderLocation) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orderLocation = orderLocation;
    }

    /**
     * Gets the email associated with the order.
     *
     * @return The email associated with the order.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email associated with the order.
     *
     * @param email The email to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number associated with the order.
     *
     * @return The phone number associated with the order.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number associated with the order.
     *
     * @param phoneNumber The phone number to be set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the order location where the order is to be delivered.
     *
     * @return The order location.
     */
    public String getOrderLocation() {
        return orderLocation;
    }

    /**
     * Sets the order location where the order is to be delivered.
     *
     * @param orderLocation The order location to be set.
     */
    public void setOrderLocation(String orderLocation) {
        this.orderLocation = orderLocation;
    }
}
