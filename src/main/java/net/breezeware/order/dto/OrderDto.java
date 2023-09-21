package net.breezeware.order.dto;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.order.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private int userId;
    private int orderId;
    private List<FoodItemDto>foodItems=new ArrayList<>();

    public OrderDto(int userId, int orderId, List<FoodItemDto> foodItems) {
        this.userId = userId;
        this.orderId = orderId;
        this.foodItems = foodItems;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<FoodItemDto> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItemDto> foodItems) {
        this.foodItems = foodItems;
    }
}
