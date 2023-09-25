package net.breezeware.order.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dao.OrderListRepository;
import net.breezeware.order.dao.OrderProcessAndDeliveryRepository;
import net.breezeware.order.dao.OrderRepository;
import net.breezeware.order.dto.*;
import net.breezeware.order.entity.Order;
import net.breezeware.order.service.api.OrderManagementService;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Implementation of the OrderManagementService interface.
 * This class provides various methods for managing food orders.
 */
public class OrderManagementServiceImpl implements OrderManagementService {

    // Instance variables
    OrderRepository orderRepository = new OrderRepository();
    OrderListRepository orderListRepository = new OrderListRepository();
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
    public int orderInCart(OrderDto orderDto) {
        boolean userCheck = orderRepository.userCheck(orderDto.getUserId());
        if (!userCheck) {
            System.out.println("You didn't have Access to the Order Section.");
            return 0;
        } else {
            orderRepository.orderInCart(orderDto.getOrderId(), orderDto.getUserId());
            List<FoodItemDto> foodItems = orderListRepository.getFoodItemCost(orderDto.getFoodItems());
            orderListRepository.addFoodOrderItem(orderDto.getOrderId(), foodItems);
            orderListRepository.updateOrderCost(orderDto.getOrderId());
            return orderListRepository.updateFoodItemQuantity(foodItems);
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
        List<FoodItem> foodItems = orderListRepository.viewOrderItems(orderId);
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
            int foodItemCost = orderListRepository.getFoodItemCost(orderUpdateDto);
            assert foodItemCost == 1;
            int recordChanged = orderListRepository.updateOrderItem(orderUpdateDto);
            assert recordChanged == 1;
            int updateOrderCost = orderListRepository.updateOrderCost(orderUpdateDto.getOrderId());
            assert updateOrderCost == 1;
            recordsChanged++;
        }
        return recordsChanged;
    }

    /**
     * Places an order with user details.
     *
     * @param orderId       The ID of the order to place.
     * @param placeOrderDto User details including email, phone number, and order location.
     * @return 1 if the order is successfully placed, 0 otherwise.
     */
    public int placeOrder(int orderId, PlaceOrderDto placeOrderDto) {
        if (validateEmail(placeOrderDto.getEmail()) && validatePhoneNumber(placeOrderDto.getPhoneNumber())) {
            return orderRepository.placeOrder(orderId, placeOrderDto);
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
    public int cancelOrder(int orderId) {
        int recordChanged = orderRepository.cancelOrder(orderId);
        assert recordChanged == 1;
        List<OrderCancelDto> orderCancelDtos = orderListRepository.cancelFoodItemList(orderId);
        assert !orderCancelDtos.isEmpty();
        return orderListRepository.changeFoodItemQuantity(orderCancelDtos);
    }

    /**
     * Retrieves a list of active orders based on status.
     *
     * @param status The status of orders to retrieve.
     * @return A list of RetrieveOrderDto objects representing active orders.
     */
    public List<RetrieveOrderDto> retrieveListOfActiveOrders(String status) {
        return orderProcessAndDeliveryRepository.retrieveListOfOrdersByStatus(status);
    }

    /**
     * Changes the status of an order.
     *
     * @param id     The ID of the order to change the status of.
     * @param status The new status for the order.
     * @return 1 if the status change is successful, 0 otherwise.
     */
    public int changeOrderStatus(int id, String status) {
        return orderProcessAndDeliveryRepository.changeOrderStatus(id, status);
    }

    /**
     * Displays the detailed information of an order.
     *
     * @param id     The ID of the order to display.
     * @param status The status of the order to display.
     * @return A RetrieveOrderDto containing detailed order information.
     */
    public RetrieveOrderDto displayOrderDetail(int id, String status) {
        return orderProcessAndDeliveryRepository.displayOrderDetail(id, status);
    }
}
