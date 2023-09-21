package net.breezeware.order.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dto.FoodItemDto;
import net.breezeware.order.dto.OrderDto;
import net.breezeware.order.service.api.OrderManagementService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderManagementServiceImplTest {
    OrderManagementService orderManagementService=new OrderManagementServiceImpl();
    @Test
    @Order(1)
    void viewFoodMenu(){
        Days day=Days.MONDAY;
        orderManagementService.viewFoodMenu(day);
    }
    @Test
    @Order(2)
    void orderInCart(){
        List<FoodItemDto> foodItems=new ArrayList<>();
        foodItems.add(new FoodItemDto(1,5));
        foodItems.add(new FoodItemDto(2,5));
        orderManagementService.orderInCart(new OrderDto(2,1,foodItems));
    }
}