package net.breezeware.order.service.api;

import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dto.FoodItemDto;
import net.breezeware.order.dto.OrderDto;

import java.util.List;

public interface OrderManagementService {
    void viewFoodMenu(Days day);
    void orderInCart(OrderDto orderDto);
    void viewOrder(int orderId);
}
