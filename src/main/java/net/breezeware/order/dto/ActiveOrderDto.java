package net.breezeware.order.dto;

import net.breezeware.order.entity.Order;

import java.util.List;

public class ActiveOrderDto {
    private Order order;
    private List<DisplayFoodItemDto> foodItems;

    public ActiveOrderDto(Order order, List<DisplayFoodItemDto> foodItems) {
        this.order = order;
        this.foodItems = foodItems;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<DisplayFoodItemDto> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<DisplayFoodItemDto> foodItems) {
        this.foodItems = foodItems;
    }
}
