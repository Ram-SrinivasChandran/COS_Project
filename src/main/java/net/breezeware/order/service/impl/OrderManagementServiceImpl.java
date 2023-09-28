package net.breezeware.order.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dao.OrderItemRepository;
import net.breezeware.order.dao.OrderProcessAndDeliveryRepository;
import net.breezeware.order.dao.OrderRepository;
import net.breezeware.order.dto.*;
import net.breezeware.order.entity.Order;
import net.breezeware.order.service.api.OrderManagementService;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Implementation of the OrderManagementService interface.
 * This class provides various methods for managing food orders.
 */
public class OrderManagementServiceImpl implements OrderManagementService {

    // Instance variables
    OrderRepository orderRepository = new OrderRepository();
    OrderItemRepository orderItemRepository = new OrderItemRepository();
    OrderProcessAndDeliveryRepository orderProcessAndDeliveryRepository = new OrderProcessAndDeliveryRepository();

    /**
     * Retrieves the food menu for a specific day.
     *
     * @param day The day for which the food menu is to be retrieved.
     * @return A list of ViewFoodMenuDto objects representing the food menu for the given day.
     */
    public List<ViewFoodMenuDto> viewFoodMenu(Days day) {
        return orderRepository.viewFoodMenu(day);
    }

    /**
     * Places an order with items in the cart.
     *
     * @param orderDto The order details including user ID and cart items.
     * @return The number of items in the order.
     */
    public int addOrderItemInCart(OrderDto orderDto) {
        boolean userCheck = orderRepository.userCheck(orderDto.getUserId());
        if (!userCheck) {
            System.out.println("You didn't have Access to the Order Section.");
            return 0;
        } else {
            orderRepository.orderInCart(orderDto.getOrderId(), orderDto.getUserId());
            List<FoodItemDto> foodItems = orderItemRepository.getFoodItemCost(orderDto.getFoodItems());
            orderItemRepository.addFoodOrderItem(orderDto.getOrderId(), foodItems);
            orderItemRepository.updateOrderCost(orderDto.getOrderId());
            return orderItemRepository.updateFoodItemQuantity(foodItems);
        }
    }

    /**
     * Views the details of an order.
     *
     * @param orderId The ID of the order to view.
     * @return A ViewOrderDto containing order details and associated food items.
     */
    public ViewOrderDto viewOrder(int orderId) {
        Order order = orderRepository.viewOrder(orderId);
        List<FoodItem> foodItems = orderItemRepository.viewOrderItems(orderId);
        return new ViewOrderDto(order, foodItems);
    }

    /**
     * Updates the quantity of food items in an order.
     *
     * @param orderUpdateDtos A list of OrderUpdateDto objects containing update information.
     * @return The number of records changed.
     */
    public int updateOrderItem(List<OrderUpdateDto> orderUpdateDtos) {
        int recordsChanged = 0;
        for (var orderUpdateDto : orderUpdateDtos) {
            int foodItemCost = orderItemRepository.getFoodItemCost(orderUpdateDto);
            assert foodItemCost == 1;
            int recordChanged = orderItemRepository.updateOrderItem(orderUpdateDto);
            assert recordChanged == 1;
            int updateOrderCost = orderItemRepository.updateOrderCost(orderUpdateDto.getOrderId());
            assert updateOrderCost == 1;
            recordsChanged++;
        }
        return recordsChanged;
    }

    /**
     * Places an order with user details.
     *
     * @param orderId       The ID of the order to place.
     * @param orderAddressDto User details including email, phone number, and order location.
     * @return 1 if the order is successfully placed, 0 otherwise.
     */
    public int placeOrder(int orderId, OrderAddressDto orderAddressDto) {
        if (validateEmail(orderAddressDto.getEmail()) && validatePhoneNumber(orderAddressDto.getPhoneNumber())) {
            return orderRepository.placeOrder(orderId, orderAddressDto);
        } else {
            System.out.println("Your Email or Phone Number is Not in correct Format");
            return 0;
        }
    }

    /**
     * Validates an email address.
     *
     * @param email The email address to validate.
     * @return true if the email is valid, false otherwise.
     */
    private boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    /**
     * Validates a phone number.
     *
     * @param phoneNumber The phone number to validate.
     * @return true if the phone number is valid, false otherwise.
     */
    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            return false;
        }
        String phoneRegex = "^[0-9()-]+$";
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }

    /**
     * Cancels an order.
     *
     * @param orderId The ID of the order to cancel.
     * @return The number of items in the order that were canceled.
     */
    public int cancelOrder(int orderId) throws SQLException {
        int recordChanged = orderRepository.cancelOrder(orderId);
        assert recordChanged == 1;
        List<OrderCancelDto> orderCancelDtos = orderItemRepository.cancelFoodItemList(orderId);
        assert !orderCancelDtos.isEmpty();
        return orderItemRepository.changeFoodItemQuantity(orderCancelDtos);
    }

    /**
     * Retrieves a list of active orders based on status.
     *
     * @param status The status of orders to retrieve.
     * @return A list of RetrieveOrderDto objects representing active orders.
     */
    public List<OrderResponseDto> retrieveOrdersByStatus(String status) {
        return orderProcessAndDeliveryRepository.retrieveListOfOrdersByStatus(status);
    }

    /**
     * Changes the status of an order.
     *
     * @param id     The ID of the order to change the status of.
     * @param status The new status for the order.
     * @return 1 if the status change is successful, 0 otherwise.
     */
    public int updateOrderStatus(int id, String status) {
        return orderProcessAndDeliveryRepository.changeOrderStatus(id, status);
    }

    /**
     {@inheritDoc}
     */
    public OrderResponseDto retrieveOrderByStatus(int id, String status) {
        return orderProcessAndDeliveryRepository.displayOrderDetail(id, status);
    }
}
