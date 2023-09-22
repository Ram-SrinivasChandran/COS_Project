package net.breezeware.order.service.impl;

import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dao.OrderListRepository;
import net.breezeware.order.dao.OrderRepository;
import net.breezeware.order.dto.FoodItemDto;
import net.breezeware.order.dto.OrderDto;
import net.breezeware.order.dto.OrderUpdateDto;
import net.breezeware.order.service.api.OrderManagementService;

import java.util.List;

public class OrderManagementServiceImpl implements OrderManagementService {
    OrderRepository orderRepository=new OrderRepository();
    OrderListRepository orderListRepository=new OrderListRepository();
    public void viewFoodMenu(Days day){
        orderRepository.viewFoodMenu(day);
    }
    public void orderInCart(OrderDto orderDto){
        boolean userCheck = orderRepository.userCheck(orderDto.getUserId());
        if(!userCheck){
            System.out.println("You didn't have Access to the Order Section.");
        }
        else{
            orderRepository.orderInCart(orderDto.getOrderId(),orderDto.getUserId());
            List<FoodItemDto> foodItems = orderListRepository.getFoodItemCost(orderDto.getFoodItems());
            orderListRepository.addFoodOrderItem(orderDto.getOrderId(),foodItems);
            orderListRepository.updateOrderCost(orderDto.getOrderId());
            orderListRepository.updateFoodItemQuantity(foodItems);
        }
    }
    public void viewOrder(int orderId){
        orderRepository.viewOrder(orderId);
        orderListRepository.viewOrderItems(orderId);
    }
    public void updateOrderItem(OrderUpdateDto orderUpdateDto){
        orderListRepository.UpdateOrderItem(orderUpdateDto);
    }
}
