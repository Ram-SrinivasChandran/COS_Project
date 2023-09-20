package net.breezeware.food.entity;

public class FoodMenu {
    private int id;
    private String name;
    private String type;
    private String availabilityOn;

    public FoodMenu(String name, String type, String availabilityOn) {
        this.name = name;
        this.type = type;
        this.availabilityOn = availabilityOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailabilityOn() {
        return availabilityOn;
    }

    public void setAvailabilityOn(String availabilityOn) {
        this.availabilityOn = availabilityOn;
    }
}
