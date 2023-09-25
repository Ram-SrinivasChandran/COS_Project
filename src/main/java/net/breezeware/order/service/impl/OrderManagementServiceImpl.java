package net.breezeware.order.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dao.OrderListRepository;
import net.breezeware.order.dao.OrderRepository;
import net.breezeware.order.dto.*;
import net.breezeware.order.entity.Order;
import net.breezeware.order.service.api.OrderManagementService;

import java.util.List;
import java.util.regex.Pattern;

public class OrderManagementServiceImpl implements OrderManagementService {
    OrderRepository orderRepository=new OrderRepository();
    OrderListRepository orderListRepository=new OrderListRepository();
    public List<ViewFoodMenuDto> viewFoodMenu(Days day){
        return orderRepository.viewFoodMenu(day);
    }
    public int orderInCart(OrderDto orderDto){
        boolean userCheck = orderRepository.userCheck(orderDto.getUserId());
        if(!userCheck){
            System.out.println("You didn't have Access to the Order Section.");
            return 0;
        }
        else{
            orderRepository.orderInCart(orderDto.getOrderId(),orderDto.getUserId());
            List<FoodItemDto> foodItems = orderListRepository.getFoodItemCost(orderDto.getFoodItems());
            orderListRepository.addFoodOrderItem(orderDto.getOrderId(),foodItems);
            orderListRepository.updateOrderCost(orderDto.getOrderId());
            return orderListRepository.updateFoodItemQuantity(foodItems);
        }
    }
    public ViewOrderDto viewOrder(int orderId){
        Order order = orderRepository.viewOrder(orderId);
        List<FoodItem> foodItems = orderListRepository.viewOrderItems(orderId);
        return new ViewOrderDto(order,foodItems);
    }
    public int updateOrderItem(List<OrderUpdateDto> orderUpdateDtos){
        int recordsChanged=0;
        for (var orderUpdateDto:
             orderUpdateDtos) {
            int foodItemCost = orderListRepository.getFoodItemCost(orderUpdateDto);
            assert foodItemCost==1;
            int recordChanged = orderListRepository.updateOrderItem(orderUpdateDto);
            assert recordChanged==1;
            int updateOrderCost = orderListRepository.updateOrderCost(orderUpdateDto.getOrderId());
            assert updateOrderCost==1;
            recordsChanged++;
        }
        return recordsChanged;
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
    public int cancelOrder(int orderId){
        int recordChanged = orderRepository.cancelOrder(orderId);
        assert recordChanged==1;
        List<OrderCancelDto> orderCancelDtos = orderListRepository.cancelFoodItemList(orderId);
        assert !orderCancelDtos.isEmpty();
        return orderListRepository.changeFoodItemQuantity(orderCancelDtos);
    }
}
