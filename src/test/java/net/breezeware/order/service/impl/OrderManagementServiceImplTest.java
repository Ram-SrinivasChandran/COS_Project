package net.breezeware.order.service.impl;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dto.FoodItemDto;
import net.breezeware.order.dto.OrderDto;
import net.breezeware.order.dto.OrderUpdateDto;
import net.breezeware.order.dto.PlaceOrderDto;
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
    @Test
    @Order(3)
    void viewOrder(){
        orderManagementService.viewOrder(1);
    }
    @Test
    @Order(4)
    void updateOrderItem(){
        List<OrderUpdateDto> orderUpdateDtos=new ArrayList<>();
        orderUpdateDtos.add(new OrderUpdateDto(1,1,10));
        orderUpdateDtos.add(new OrderUpdateDto(1,2,5));
        orderManagementService.updateOrderItem(orderUpdateDtos);
    }
    @Test
    @Order(5)
    void placeOrder(){
        PlaceOrderDto placeOrderDto=new PlaceOrderDto("chand2ram@gmail.com","9677963066","Ganapathy");
        orderManagementService.placeOrder(1,placeOrderDto);
    }
}