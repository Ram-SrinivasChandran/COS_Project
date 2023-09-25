package net.breezeware.order.dto;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.order.entity.Order;

import java.util.List;

public class ViewOrderDto {
    private Order order;
    private List<FoodItem> foodItems;

    public ViewOrderDto(Order order, List<FoodItem> foodItems) {
        this.order = order;
        this.foodItems = foodItems;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
