package net.breezeware.order.service.impl;

import net.breezeware.food.entity.FoodItem;
import net.breezeware.food.entity.FoodMenu;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dto.*;
import net.breezeware.order.enumeration.OrderStatus;
import net.breezeware.order.service.api.OrderManagementService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test class for {@link OrderManagementServiceImpl}.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderManagementServiceImplTest {
    OrderManagementService orderManagementService = new OrderManagementServiceImpl();

    /**
     * Test the {@link OrderManagementService#viewFoodMenu(Days)} method to view the food menu for a specific day.
     */
    @Test
    @Order(1)
    void testViewFoodMenu() {
        Days day = Days.TUESDAY;
        List<ViewFoodMenuDto> viewFoodMenuDtos = orderManagementService.viewFoodMenu(day);
        for (var viewFoodMenu : viewFoodMenuDtos) {
            FoodMenu foodMenu = viewFoodMenu.getFoodMenu();
            System.out.println("Id : " + foodMenu.getId() +
                    ", Name: " + foodMenu.getName() +
                    ", Type : " + foodMenu.getType() +
                    ", AvailabilityOn : " + foodMenu.getAvailabilityOn());
            List<FoodItem> foodItems = viewFoodMenu.getFoodItems();
            for (var foodItem : foodItems) {
                System.out.println("     Id : " + foodItem.getId() +
                        ", Name : " + foodItem.getName() +
                        ", Cost : " + foodItem.getCost() +
                        ", Quantity : " + foodItem.getQuantity());
            }
        }
        assertEquals(3, viewFoodMenuDtos.size());
    }

    /**
     * Test the {@link OrderManagementService#orderInCart(OrderDto)} method to add items to the cart.
     */
    @Test
    @Order(2)
    void testOrderInCart() {
        List<FoodItemDto> foodItems = new ArrayList<>();
        foodItems.add(new FoodItemDto(5, 5));
        foodItems.add(new FoodItemDto(6, 5));
        assertEquals(foodItems.size(), orderManagementService.orderInCart(new OrderDto(2, 3, foodItems)));
    }

    /**
     * Test the {@link OrderManagementService#viewOrder(int)} method to view order details.
     */
    @Test
    @Order(3)
    void testViewOrder() {
        ViewOrderDto viewOrderDto = orderManagementService.viewOrder(3);
        net.breezeware.order.entity.Order order = viewOrderDto.getOrder();
        System.out.println("Id : " + order.getId() +
                ", User Id : " + order.getUserId() +
                ", Total Cost : " + order.getTotalCost() +
                ", Status : " + order.getStatus());
        List<FoodItem> foodItems = viewOrderDto.getFoodItems();
        for (var foodItem : foodItems) {
            System.out.println("    Food ID : " + foodItem.getId() +
                    ", Food Name : " + foodItem.getName() +
                    ", Quantity : " + foodItem.getQuantity() +
                    ", Cost : " + foodItem.getCost());
        }
        assertNotEquals(null, viewOrderDto);
        assertEquals(2, foodItems.size());
    }

    /**
     * Test the {@link OrderManagementService#updateOrderItem(List)} method to update order items.
     */
    @Test
    @Order(4)
    void testUpdateOrderItem() {
        List<OrderUpdateDto> orderUpdateDtos = new ArrayList<>();
        orderUpdateDtos.add(new OrderUpdateDto(3, 5, 10));
        orderUpdateDtos.add(new OrderUpdateDto(3, 6, 5));
        assertEquals(orderUpdateDtos.size(), orderManagementService.updateOrderItem(orderUpdateDtos));
    }

    /**
     * Test the {@link OrderManagementService#placeOrder(int, OrderAddressDto)} method to place an order.
     */
    @Test
    @Order(5)
    void testPlaceOrder() {
        OrderAddressDto orderAddressDto = new OrderAddressDto("chand2ram@gmail.com", "9677963066", "Ganapathy");
        assertEquals(1, orderManagementService.placeOrder(3, orderAddressDto));
    }

    /**
     * Test the {@link OrderManagementService#cancelOrder(int)} method to cancel an order.
     */
    @Test
    @Order(6)
    void testCancelOrder() {
        assertEquals(2, orderManagementService.cancelOrder(1));
    }

    /**
     * Test the {@link OrderManagementService#retrieveOrdersByStatus(String)} method
     * to retrieve a list of active orders with the given status.
     */
    @Test
    @Order(7)
    void testRetrieveListOfActiveOrders() {
        List<OrderResponseDto> orderResponseDtos = orderManagementService.retrieveOrdersByStatus(OrderStatus.ORDER_PLACED.toString());
        for (var activeOrderDto : orderResponseDtos) {
            net.breezeware.order.entity.Order order = activeOrderDto.getOrder();
            System.out.println("Id : " + order.getId() +
                    ", User Id : " + order.getUserId() +
                    ", Total Cost : " + order.getTotalCost() +
                    ", Email : " + order.getEmail() +
                    ", Phone Number : " + order.getPhoneNumber() +
                    ", Order Location : " + order.getLocation() +
                    ", Order Status : " + order.getStatus() +
                    ", Ordered On : " + order.getOrderOn().substring(0, 10) + " " + order.getOrderOn().substring(11, 16) +
                    ", Delivery On : " + order.getDeliveryOn().substring(0, 10) + " " + order.getDeliveryOn().substring(11, 16));
            List<DisplayFoodItemDto> displayFoodItemDtos = activeOrderDto.getFoodItems();
            for (var displayFoodItemDto : displayFoodItemDtos) {
                FoodItemDto foodItemDto = displayFoodItemDto.getFoodItemDto();
                System.out.println("    Food Id : " + foodItemDto.getFoodItemId() +
                        ", Food Name : " + displayFoodItemDto.getFoodItemName() +
                        ", Food Quantity : " + foodItemDto.getFoodItemQuantity() +
                        ", Cost : " + foodItemDto.getFoodCost());
            }
        }
        assertEquals(1, orderResponseDtos.size());
    }

    /**
     * Test the {@link OrderManagementService#retrieveOrdersByStatus(String)} method
     * to retrieve a list of received orders with the given status.
     */
    @Test
    @Order(8)
    void testRetrieveListOfReceivedOrders() {
        List<OrderResponseDto> orderResponseDtos = orderManagementService.retrieveOrdersByStatus(OrderStatus.RECEIVED_ORDER.toString());
        for (var activeOrderDto : orderResponseDtos) {
            net.breezeware.order.entity.Order order = activeOrderDto.getOrder();
            System.out.println("Id : " + order.getId() +
                    ", User Id : " + order.getUserId() +
                    ", Total Cost : " + order.getTotalCost() +
                    ", Email : " + order.getEmail() +
                    ", Phone Number : " + order.getPhoneNumber() +
                    ", Order Location : " + order.getLocation() +
                    ", Order Status : " + order.getStatus() +
                    ", Ordered On : " + order.getOrderOn().substring(0, 10) + " " + order.getOrderOn().substring(11, 16) +
                    ", Delivery On : " + order.getDeliveryOn().substring(0, 10) + " " + order.getDeliveryOn().substring(11, 16));
            List<DisplayFoodItemDto> displayFoodItemDtos = activeOrderDto.getFoodItems();
            for (var displayFoodItemDto : displayFoodItemDtos) {
                FoodItemDto foodItemDto = displayFoodItemDto.getFoodItemDto();
                System.out.println("    Food Id : " + foodItemDto.getFoodItemId() +
                        ", Food Name : " + displayFoodItemDto.getFoodItemName() +
                        ", Food Quantity : " + foodItemDto.getFoodItemQuantity() +
                        ", Cost : " + foodItemDto.getFoodCost());
            }
        }
        assertEquals(2, orderResponseDtos.size());
    }

    /**
     * Test the {@link OrderManagementService#updateOrderStatus(int, String)} method
     * to change the status of an order to "Waiting for Delivery".
     */
    @Test
    @Order(9)
    void testUpdateStatusToWaitingForDelivery() {
        assertEquals(1, orderManagementService.updateOrderStatus(2, OrderStatus.ORDER_PREPARED_WAITING_FOR_DELIVERY.toString()));
    }

    /**
     * Test the {@link OrderManagementService#updateOrderStatus(int, String)} method
     * to change the status of an order to "Pending Delivery".
     */
    @Test
    @Order(10)
    void testUpdateStatusToPendingDelivery() {
        assertEquals(1, orderManagementService.updateOrderStatus(2, OrderStatus.PENDING_DELIVERY.toString()));
    }

    /**
     * Test the {@link OrderManagementService#updateOrderStatus(int, String)} method
     * to change the status of an order to "Order Delivered".
     */
    @Test
    @Order(11)
    void testUpdateStatusToOrderDelivered() {
        assertEquals(1, orderManagementService.updateOrderStatus(2, OrderStatus.ORDER_DELIVERED.toString()));
    }

    /**
     * Test the {@link OrderManagementService#retrieveOrdersByStatus(String)} method
     * to retrieve a list of cancelled orders with the given status.
     */
    @Test
    @Order(12)
    void testRetrieveListOfCancelledOrders() {
        List<OrderResponseDto> orderResponseDtos = orderManagementService.retrieveOrdersByStatus(OrderStatus.ORDER_CANCELLED.toString());
        for (var retrieveOrderDto : orderResponseDtos) {
            net.breezeware.order.entity.Order order = retrieveOrderDto.getOrder();
            System.out.println("Id : " + order.getId() +
                    ", User Id : " + order.getUserId() +
                    ", Total Cost : " + order.getTotalCost() +
                    ", Email : " + order.getEmail() +
                    ", Phone Number : " + order.getPhoneNumber() +
                    ", Order Location : " + order.getLocation() +
                    ", Order Status : " + order.getStatus() +
                    ", Ordered On : " + order.getOrderOn().substring(0, 10) + " " + order.getOrderOn().substring(11, 16) +
                    ", Delivery On : " + order.getDeliveryOn().substring(0, 10) + " " + order.getDeliveryOn().substring(11, 16));
            List<DisplayFoodItemDto> displayFoodItemDtos = retrieveOrderDto.getFoodItems();
            for (var displayFoodItemDto : displayFoodItemDtos) {
                FoodItemDto foodItemDto = displayFoodItemDto.getFoodItemDto();
                System.out.println("    Food Id : " + foodItemDto.getFoodItemId() +
                        ", Food Name : " + displayFoodItemDto.getFoodItemName() +
                        ", Food Quantity : " + foodItemDto.getFoodItemQuantity() +
                        ", Cost : " + foodItemDto.getFoodCost());
            }
        }
        assertEquals(1, orderResponseDtos.size());
    }

    /**
     * Test the {@link OrderManagementService#retrieveOrderByStatus(int, String)} method
     * to view details of a cancelled order.
     */
    @Test
    @Order(13)
    void testViewCancelledOrderDetail() {
        OrderResponseDto orderResponseDto = orderManagementService.retrieveOrderByStatus(1, OrderStatus.ORDER_CANCELLED.toString());
        net.breezeware.order.entity.Order order = orderResponseDto.getOrder();
        System.out.println("Id : " + order.getId() +
                ", User Id : " + order.getUserId() +
                ", Total Cost : " + order.getTotalCost() +
                ", Email : " + order.getEmail() +
                ", Phone Number : " + order.getPhoneNumber() +
                ", Order Location : " + order.getLocation() +
                ", Order Status : " + order.getStatus() +
                ", Ordered On : " + order.getOrderOn().substring(0, 10) + " " + order.getOrderOn().substring(11, 16) +
                ", Delivery On : " + order.getDeliveryOn().substring(0, 10) + " " + order.getDeliveryOn().substring(11, 16));
        List<DisplayFoodItemDto> displayFoodItemDtos = orderResponseDto.getFoodItems();
        for (var displayFoodItemDto : displayFoodItemDtos) {
            FoodItemDto foodItemDto = displayFoodItemDto.getFoodItemDto();
            System.out.println("    Food Id : " + foodItemDto.getFoodItemId() +
                    ", Food Name : " + displayFoodItemDto.getFoodItemName() +
                    ", Food Quantity : " + foodItemDto.getFoodItemQuantity() +
                    ", Cost : " + foodItemDto.getFoodCost());
        }
        assertNotEquals(null, orderResponseDto);
    }

    /**
     * Test the {@link OrderManagementService#retrieveOrdersByStatus(String)} method
     * to retrieve a list of completed orders with the given status.
     */
    @Test
    @Order(14)
    void retrieveListOfCompletedOrders() {
        List<OrderResponseDto> orderResponseDtos = orderManagementService.retrieveOrdersByStatus(OrderStatus.ORDER_DELIVERED.toString());
        for (var retrieveOrderDto : orderResponseDtos) {
            net.breezeware.order.entity.Order order = retrieveOrderDto.getOrder();
            System.out.println("Id : " + order.getId() +
                    ", User Id : " + order.getUserId() +
                    ", Total Cost : " + order.getTotalCost() +
                    ", Email : " + order.getEmail() +
                    ", Phone Number : " + order.getPhoneNumber() +
                    ", Order Location : " + order.getLocation() +
                    ", Order Status : " + order.getStatus() +
                    ", Ordered On : " + order.getOrderOn().substring(0, 10) + " " + order.getOrderOn().substring(11, 16) +
                    ", Delivery On : " + order.getDeliveryOn().substring(0, 10) + " " + order.getDeliveryOn().substring(11, 16));
            List<DisplayFoodItemDto> displayFoodItemDtos = retrieveOrderDto.getFoodItems();
            for (var displayFoodItemDto : displayFoodItemDtos) {
                FoodItemDto foodItemDto = displayFoodItemDto.getFoodItemDto();
                System.out.println("    Food Id : " + foodItemDto.getFoodItemId() +
                        ", Food Name : " + displayFoodItemDto.getFoodItemName() +
                        ", Food Quantity : " + foodItemDto.getFoodItemQuantity() +
                        ", Cost : " + foodItemDto.getFoodCost());
            }
        }
        assertEquals(1, orderResponseDtos.size());
    }

    /**
     * Test the {@link OrderManagementService#retrieveOrderByStatus(int, String)} method
     * to view details of a completed order.
     */
    @Test
    @Order(15)
    void viewCompletedOrder() {
        OrderResponseDto orderResponseDto = orderManagementService.retrieveOrderByStatus(2, OrderStatus.ORDER_DELIVERED.toString());
        net.breezeware.order.entity.Order order = orderResponseDto.getOrder();
        System.out.println("Id : " + order.getId() +
                ", User Id : " + order.getUserId() +
                ", Total Cost : " + order.getTotalCost() +
                ", Email : " + order.getEmail() +
                ", Phone Number : " + order.getPhoneNumber() +
                ", Order Location : " + order.getLocation() +
                ", Order Status : " + order.getStatus() +
                ", Ordered On : " + order.getOrderOn().substring(0, 10) + " " + order.getOrderOn().substring(11, 16) +
                ", Delivery On : " + order.getDeliveryOn().substring(0, 10) + " " + order.getDeliveryOn().substring(11, 16));
        List<DisplayFoodItemDto> displayFoodItemDtos = orderResponseDto.getFoodItems();
        for (var displayFoodItemDto : displayFoodItemDtos) {
            FoodItemDto foodItemDto = displayFoodItemDto.getFoodItemDto();
            System.out.println("    Food Id : " + foodItemDto.getFoodItemId() +
                    ", Food Name : " + displayFoodItemDto.getFoodItemName() +
                    ", Food Quantity : " + foodItemDto.getFoodItemQuantity() +
                    ", Cost : " + foodItemDto.getFoodCost());
        }
        assertNotEquals(null, orderResponseDto);
    }
}
