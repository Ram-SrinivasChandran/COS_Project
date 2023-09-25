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

import java.time.LocalDate;
import java.time.LocalTime;
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
        foodItems.add(new FoodItemDto(3,5));
        foodItems.add(new FoodItemDto(4,5));
        assertEquals(foodItems.size(),orderManagementService.orderInCart(new OrderDto(2,2,foodItems)));
    }
    @Test
    @Order(3)
    void viewOrder(){
        ViewOrderDto viewOrderDto = orderManagementService.viewOrder(2);
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
        orderUpdateDtos.add(new OrderUpdateDto(2,3,10));
        orderUpdateDtos.add(new OrderUpdateDto(2,4,5));
        assertEquals(orderUpdateDtos.size(),orderManagementService.updateOrderItem(orderUpdateDtos));
    }
    @Test
    @Order(5)
    void placeOrder(){
        PlaceOrderDto placeOrderDto=new PlaceOrderDto("chand2ram@gmail.com","9677963066","Ganapathy");
        assertEquals(1,orderManagementService.placeOrder(2,placeOrderDto));
    }

    @Test
    @Order(6)
    void cancelOrder(){
        assertEquals(2,orderManagementService.cancelOrder(1));
    }
    @Test
    @Order(7)
    void retrieveListOfActiveOrders(){
        List<ActiveOrderDto> activeOrderDtos=orderManagementService.retrieveListOfActiveOrders();
        for (var activeOrderDto:
             activeOrderDtos) {
            net.breezeware.order.entity.Order order=activeOrderDto.getOrder();
            System.out.println("Id : "+order.getId()+
                    ", User Id : "+order.getUserId()+
                    ", Total Cost : "+order.getTotalCost()+
                    ", Email : "+order.getEmail()+
                    ", Phone Number : "+order.getPhoneNumber()+
                    ", Order Location : "+order.getOrderLocation()+
                    ", Order Status : "+order.getStatus()+
                    ", Ordered On : "+order.getOrderOn().substring(0,10)+" "+order.getOrderOn().substring(11,16)+
                    ", Delivery On : "+order.getDeliveryOn().substring(0,10)+" "+order.getDeliveryOn().substring(11,16));
            List<DisplayFoodItemDto> displayFoodItemDtos=activeOrderDto.getFoodItems();
            for (var displayFoodItemDto:
                 displayFoodItemDtos) {
                FoodItemDto foodItemDto=displayFoodItemDto.getFoodItemDto();
                System.out.println("    Food Id : "+foodItemDto.getFoodItemId()+
                        ", Food Name : "+displayFoodItemDto.getFoodItemName()+
                        ", Food Quantity : "+foodItemDto.getFoodItemQuantity()+
                        ", Cost : "+foodItemDto.getFoodCost());
            }
        }
    }
}