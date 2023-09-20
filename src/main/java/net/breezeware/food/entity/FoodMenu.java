package net.breezeware.food.entity;

/**
 * Represents a food menu in the system, specifying its name, type, and availability schedule.
 */
public class FoodMenu {
    private int id;               // Unique identifier for the food menu.
    private String name;          // The name of the food menu.
    private String type;          // The type of food menu (e.g., Breakfast, Lunch).
    private String availabilityOn; // The availability schedule (e.g., Monday, Tuesday).

    /**
     * Constructs a new instance of FoodMenu.
     *
     * @param name           The name of the food menu.
     * @param type           The type of food menu (e.g., Breakfast, Lunch).
     * @param availabilityOn The availability schedule (e.g., Monday, Tuesday).
     */
    public FoodMenu(String name, String type, String availabilityOn) {
        this.name = name;
        this.type = type;
        this.availabilityOn = availabilityOn;
    }

    /**
     * Constructs a new instance of FoodMenu with an ID.
     *
     * @param id             The unique identifier for the food menu.
     * @param name           The name of the food menu.
     * @param type           The type of food menu (e.g., Breakfast, Lunch).
     * @param availabilityOn The availability schedule (e.g., Monday, Tuesday).
     */
    public FoodMenu(int id, String name, String type, String availabilityOn) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.availabilityOn = availabilityOn;
    }

    /**
     * Get the unique identifier for the food menu.
     *
     * @return The identifier for the food menu.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier for the food menu.
     *
     * @param id The identifier for the food menu.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the food menu.
     *
     * @return The name of the food menu.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the food menu.
     *
     * @param name The name of the food menu.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the type of the food menu.
     *
     * @return The type of the food menu (e.g., Breakfast, Lunch).
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the food menu.
     *
     * @param type The type of the food menu (e.g., Breakfast, Lunch).
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the availability schedule of the food menu.
     *
     * @return The availability schedule (e.g., Monday, Tuesday).
     */
    public String getAvailabilityOn() {
        return availabilityOn;
    }

    /**
     * Set the availability schedule of the food menu.
     *
     * @param availabilityOn The availability schedule (e.g., Monday, Tuesday).
     */
    public void setAvailabilityOn(String availabilityOn) {
        this.availabilityOn = availabilityOn;
    }
}
