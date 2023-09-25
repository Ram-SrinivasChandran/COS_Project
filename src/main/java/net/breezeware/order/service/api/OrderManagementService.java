package net.breezeware.order.service.api;

import net.breezeware.food.enumeration.Days;
import net.breezeware.order.dto.*;

import java.util.List;

public interface OrderManagementService {
    List<ViewFoodMenuDto> viewFoodMenu(Days day);
    int orderInCart(OrderDto orderDto);
    ViewOrderDto viewOrder(int orderId);
    int updateOrderItem(List<OrderUpdateDto> orderUpdateDtos);
    int placeOrder(int orderId,PlaceOrderDto placeOrderDto);
    int cancelOrder(int orderId);
    List<RetrieveOrderDto> retrieveListOfActiveOrders(String status);
    int changeOrderStatus(int id,String status);
    RetrieveOrderDto displayOrderDetail(int id,String status);
}
