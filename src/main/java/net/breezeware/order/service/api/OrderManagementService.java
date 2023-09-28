package net.breezeware.order.service.api;

import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dto.*;

import java.sql.SQLException;
import java.util.List;

/**
 * The OrderManagementService interface defines the contract for managing orders and related operations.
 */
public interface OrderManagementService {

    /**
     * Retrieve a list of food menus available for a specific day.
     *
     * @param day The day for which food menus are requested.
     * @return A list of ViewFoodMenuDto objects representing the available food menus.
     */
    List<ViewFoodMenuDto> viewFoodMenu(Days day);

    /**
     * Place an order for food items and add them to the user's cart.
     *
     * @param orderDto The OrderDto containing order details.
     * @return The number of food items added to the cart.
     */
    int addOrderItemInCart(OrderDto orderDto);

    /**
     * Retrieve details of a specific order, including the associated food items.
     *
     * @param orderId The unique identifier of the order.
     * @return A ViewOrderDto object containing order and food item details.
     */
    ViewOrderDto viewOrder(int orderId);

    /**
     * Update the quantity of food items in an existing order.
     *
     * @param orderUpdateDtos A list of OrderUpdateDto objects containing order item update details.
     * @return The number of order items successfully updated.
     */
    int updateOrderItem(List<OrderUpdateDto> orderUpdateDtos);

    /**
     * Place an order with user contact information such as email and phone number.
     *
     * @param orderId        The unique identifier of the order.
     * @param orderAddressDto  The PlaceOrderDto containing user contact information.
     * @return 1 if the order is successfully placed, 0 otherwise.
     */
    int placeOrder(int orderId, OrderAddressDto orderAddressDto);

    /**
     * Cancel a specific order and restore the quantity of food items.
     *
     * @param orderId The unique identifier of the order to be canceled.
     * @return The number of food items whose quantity was restored.
     */
    int cancelOrder(int orderId) throws SQLException;

    /**
     * Retrieve a list of orders with a specific status (e.g., "ORDER_PLACED").
     *
     * @param status The status of orders to be retrieved.
     * @return A list of RetrieveOrderDto objects containing order details.
     */
    List<OrderResponseDto> retrieveOrdersByStatus(String status);

    /**
     * Change the status of a specific order.
     *
     * @param id     The unique identifier of the order.
     * @param status The new status to be set for the order.
     * @return 1 if the order status is successfully updated, 0 otherwise.
     */
    int updateOrderStatus(int id, String status);

    /**
     * Display detailed information about a specific order with a given status.
     *
     * @param id     The unique identifier of the order.
     * @param status The status of the order to be displayed.
     * @return A RetrieveOrderDto object containing detailed order information.
     */
    OrderResponseDto retrieveOrderByStatus(int id, String status);
}
