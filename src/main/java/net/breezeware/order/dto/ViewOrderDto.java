package net.breezeware.order.dto;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.order.entity.Order;

import java.util.List;

/**
 * The ViewOrderDto class represents the data transfer object for viewing an order along with its associated food items.
 */
public class ViewOrderDto {

    /**
     * The order associated with the DTO.
     */
    private Order order;

    /**
     * The list of food items included in the order.
     */
    private List<FoodItem> foodItems;

    /**
     * Constructs a ViewOrderDto with the specified order and list of food items.
     *
     * @param order      The order to be viewed.
     * @param foodItems  The list of food items included in the order.
     */
    public ViewOrderDto(Order order, List<FoodItem> foodItems) {
        this.order = order;
        this.foodItems = foodItems;
    }

    /**
     * Gets the order associated with the DTO.
     *
     * @return The order associated with the DTO.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the order associated with the DTO.
     *
     * @param order The order to be set.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Gets the list of food items included in the order.
     *
     * @return The list of food items.
     */
    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    /**
     * Sets the list of food items included in the order.
     *
     * @param foodItems The list of food items to be set.
     */
    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
