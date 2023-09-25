package net.breezeware.order.service.impl;
import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dto.*;
import net.breezeware.order.service.api.OrderManagementService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderManagementServiceImplTest {
    OrderManagementService orderManagementService=new OrderManagementServiceImpl();
    @Test
    @Order(1)
    void viewFoodMenu(){
        Days day=Days.TUESDAY;
        List<ViewFoodMenuDto> viewFoodMenuDtos = orderManagementService.viewFoodMenu(day);
        for (var viewFoodMenu:
             viewFoodMenuDtos) {
            FoodMenu foodMenu=viewFoodMenu.getFoodMenu();
            System.out.println("Id : "+foodMenu.getId()+
                    ", Name: "+foodMenu.getName()+
                    ", Type : "+foodMenu.getType()+
                    ", AvailabilityOn : "+foodMenu.getAvailabilityOn());
            List<FoodItem> foodItems=viewFoodMenu.getFoodItems();
            for (var foodItem:
                 foodItems) {
                System.out.println("     Id : " + foodItem.getId() +
                        ", Name : " + foodItem.getName() +
                        ", Cost : " + foodItem.getCost() +
                        ", Quantity : " + foodItem.getQuantity());
            }
        }
        assertEquals(3,viewFoodMenuDtos.size());
    }
    @Test
    @Order(2)
    void orderInCart(){
        List<FoodItemDto> foodItems=new ArrayList<>();
        foodItems.add(new FoodItemDto(1,5));
        foodItems.add(new FoodItemDto(2,5));
        assertEquals(foodItems.size(),orderManagementService.orderInCart(new OrderDto(2,1,foodItems)));
    }
    @Test
    @Order(3)
    void viewOrder(){
        ViewOrderDto viewOrderDto = orderManagementService.viewOrder(1);
        net.breezeware.order.entity.Order order=viewOrderDto.getOrder();
        System.out.println("Id : "+order.getId()+
                ", User Id : "+order.getUserId()+
                ", Total Cost : "+order.getTotalCost()+
                ", Status : "+order.getStatus());
        List<FoodItem> foodItems=viewOrderDto.getFoodItems();
        for (var foodItem:
             foodItems) {
            System.out.println("    Food ID : "+foodItem.getId()+
                    ", Food Name : "+foodItem.getName()+
                    ", Quantity : "+foodItem.getQuantity()+
                    ", Cost : "+foodItem.getCost());
        }
        assertNotEquals(null,viewOrderDto);
        assertEquals(2,foodItems.size());
    }
    @Test
    @Order(4)
    void updateOrderItem(){
        List<OrderUpdateDto> orderUpdateDtos=new ArrayList<>();
        orderUpdateDtos.add(new OrderUpdateDto(1,1,10));
        orderUpdateDtos.add(new OrderUpdateDto(1,2,5));
        assertEquals(orderUpdateDtos.size(),orderManagementService.updateOrderItem(orderUpdateDtos));
    }
    @Test
    @Order(5)
    void placeOrder(){
        PlaceOrderDto placeOrderDto=new PlaceOrderDto("chand2ram@gmail.com","9677963066","Ganapathy");
        assertEquals(1,orderManagementService.placeOrder(1,placeOrderDto));
    }

    @Test
    @Order(6)
    void cancelOrder(){
        assertEquals(2,orderManagementService.cancelOrder(1));
    }
}