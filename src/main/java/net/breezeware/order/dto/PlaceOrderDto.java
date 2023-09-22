package net.breezeware.order.dto;

public class PlaceOrderDto {
    private String email;
    private String phoneNumber;
    private String OrderLocation;

    public PlaceOrderDto(String email, String phoneNumber, String orderLocation) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        OrderLocation = orderLocation;
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
        return OrderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        OrderLocation = orderLocation;
    }
}
