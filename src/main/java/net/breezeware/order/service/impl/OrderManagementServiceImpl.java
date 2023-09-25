package net.breezeware.order.service.impl;

import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dao.OrderListRepository;
import net.breezeware.order.dao.OrderRepository;
import net.breezeware.order.dto.FoodItemDto;
import net.breezeware.order.dto.OrderDto;
import net.breezeware.order.dto.OrderUpdateDto;
import net.breezeware.order.dto.PlaceOrderDto;
import net.breezeware.order.service.api.OrderManagementService;

import java.util.List;
import java.util.regex.Pattern;

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
    public void updateOrderItem(List<OrderUpdateDto> orderUpdateDtos){
        for (var orderUpdateDto:
             orderUpdateDtos) {
            orderListRepository.getFoodItemCost(orderUpdateDto);
            orderListRepository.UpdateOrderItem(orderUpdateDto);
            orderListRepository.updateOrderCost(orderUpdateDto.getOrderId());
        }
    }
    public int placeOrder(int orderId,PlaceOrderDto placeOrderDto){
        if(validateEmail(placeOrderDto.getEmail()) && validatePhoneNumber(placeOrderDto.getPhoneNumber())){
            return orderRepository.placeOrder(orderId, placeOrderDto);
        }
        else{
            System.out.println("Your Email or Phone Number is Not in correct Format");
            return 0;
        }
    }
    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            return false;
        }
        String phoneRegex = "^[0-9()-]+$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }
}
