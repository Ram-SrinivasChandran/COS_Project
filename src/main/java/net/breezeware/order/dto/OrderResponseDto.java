package net.breezeware.order.dto;

import net.breezeware.order.entity.Order;

import java.util.List;

/**
 * The RetrieveOrderDto class represents a data transfer object for retrieving order information along with its associated food items.
 */
public class OrderResponseDto {

    /**
     * The order associated with the DTO.
     */
    private Order order;

    /**
     * The list of food items associated with the order.
     */
    private List<FoodItemDto> foodItems;

    /**
     * Constructs a RetrieveOrderDto with the specified order and list of food items.
     *
     * @param order      The order to be retrieved.
     * @param foodItems  The list of food items associated with the order.
     */
    public OrderResponseDto(Order order, List<FoodItemDto> foodItems) {
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
     * Gets the list of food items associated with the order.
     *
     * @return The list of food items.
     */
    public List<FoodItemDto> getFoodItems() {
        return foodItems;
    }

    /**
     * Sets the list of food items associated with the order.
     *
     * @param foodItems The list of food items to be set.
     */
    public void setFoodItems(List<FoodItemDto> foodItems) {
        this.foodItems = foodItems;
    }
}
