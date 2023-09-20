package net.breezeware.food.entity;

/**
 * Represents a food item in the system, specifying its name, cost, and quantity.
 */
public class FoodItem {
    private int id;          // Unique identifier for the food item.
    private String name;     // The name of the food item.
    private double cost;     // The cost of the food item.
    private int quantity;    // The quantity of the food item.

    /**
     * Constructs a new instance of FoodItem.
     *
     * @param name     The name of the food item.
     * @param cost     The cost of the food item.
     * @param quantity The quantity of the food item.
     */
    public FoodItem(String name, double cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    /**
     * Constructs a new instance of FoodItem with an ID.
     *
     * @param id       The unique identifier for the food item.
     * @param name     The name of the food item.
     * @param cost     The cost of the food item.
     * @param quantity The quantity of the food item.
     */
    public FoodItem(int id, String name, double cost, int quantity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    /**
     * Get the unique identifier for the food item.
     *
     * @return The identifier for the food item.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier for the food item.
     *
     * @param id The identifier for the food item.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the food item.
     *
     * @return The name of the food item.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the food item.
     *
     * @param name The name of the food item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the cost of the food item.
     *
     * @return The cost of the food item.
     */
    public double getCost() {
        return cost;
    }

    /**
     * Set the cost of the food item.
     *
     * @param cost The cost of the food item.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Get the quantity of the food item.
     *
     * @return The quantity of the food item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the food item.
     *
     * @param quantity The quantity of the food item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the food item.
     *
     * @return A string representation of the food item.
     */
    @Override
    public String toString() {
        return "FoodItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", quantity=" + quantity +
                '}';
    }
}
