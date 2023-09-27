package net.breezeware.order.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.order.dto.OrderResponseDto;
import net.breezeware.order.dto.FoodItemDto;
import net.breezeware.order.entity.Order;
import net.breezeware.order.enumeration.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The OrderProcessAndDeliveryRepository class provides data access methods for managing order processing and delivery.
 */
public class OrderProcessAndDeliveryRepository {
    Connection connection;
    public static final String ORDER_TABLE = "\"order\"";
    public static final String ORDER_ITEM_TABLE = "order_item";

    /**
     * Retrieves a list of orders by status.
     *
     * @param status The status of the orders to be retrieved.
     * @return A list of RetrieveOrderDto objects representing the orders with the specified status.
     */
    public List<OrderResponseDto> retrieveListOfOrdersByStatus(String status) {
        List<Order> orders = new ArrayList<>();
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + ORDER_TABLE + " ORDER BY delivery_on");
            while (resultSet.next()) {
                if (resultSet.getString("status").equals(status)) {
                    orders.add(new Order(resultSet.getInt("id"), resultSet.getInt("user_id"),
                            resultSet.getDouble("total_cost"), resultSet.getString("email"),
                            resultSet.getString("phone_number"), resultSet.getString("order_location"),
                            resultSet.getString("status"), resultSet.getString("order_on"),
                            resultSet.getString("delivery_on")));
                }
            }
            resultSet.close();
            statement.close();
            for (var order : orders) {
                List<FoodItemDto> foodItemDtos = new ArrayList<>();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1
                        .executeQuery("SELECT * FROM " + ORDER_ITEM_TABLE + " WHERE order_id=" + order.getId());
                while (resultSet1.next()) {
                    foodItemDtos.add(new FoodItemDto(resultSet1.getInt("food_item_id"), resultSet1.getInt("quantity"),
                            resultSet1.getDouble("cost")));
                }
                resultSet1.close();
                statement.close();
                for (var foodItemDto : foodItemDtos) {
                    Statement statement2 = connection.createStatement();
                    ResultSet resultSet2 = statement2
                            .executeQuery("SELECT * FROM food_item WHERE id=" + foodItemDto.getFoodItemId());
                    if (resultSet2.next()) {
                        foodItemDto.setFoodItemName(resultSet2.getString("name"));
                    }
                    resultSet2.close();
                    statement2.close();
                }
                orderResponseDtos.add(new OrderResponseDto(order, foodItemDtos));
            }
            for (var order : orders) {
                if (order.getStatus().equals(OrderStatus.ORDER_PLACED.toString())) {
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE " + ORDER_TABLE + " SET status=? WHERE id=" + order.getId());
                    preparedStatement.setString(1, String.valueOf(OrderStatus.RECEIVED_ORDER));
                    preparedStatement.execute();
                    preparedStatement.close();
                }
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orderResponseDtos;
    }

    /**
     * Changes the status of an order.
     *
     * @param id     The ID of the order to change the status for.
     * @param status The new status of the order.
     * @return The number of records changed in the database.
     */
    public int changeOrderStatus(int id, String status) {
        String orderStatus = null;
        int recordChanged = 0;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + ORDER_TABLE + " WHERE id=" + id);
            if (resultSet.next()) {
                orderStatus = resultSet.getString("status");
            }
            resultSet.close();
            statement.close();
            assert orderStatus != null;
            if (orderStatus.equals(OrderStatus.RECEIVED_ORDER.toString())) {
                if (status.equals(OrderStatus.ORDER_PREPARED_WAITING_FOR_DELIVERY.toString())) {
                    PreparedStatement preparedStatement = connection
                            .prepareStatement("UPDATE " + ORDER_TABLE + " SET status=? WHERE id=" + id);
                    preparedStatement.setString(1, OrderStatus.ORDER_PREPARED_WAITING_FOR_DELIVERY.toString());
                    recordChanged = preparedStatement.executeUpdate();
                    preparedStatement.close();
                }
            } else if (orderStatus.equals(OrderStatus.ORDER_PREPARED_WAITING_FOR_DELIVERY.toString())) {
                if (status.equals(OrderStatus.PENDING_DELIVERY.toString())) {
                    PreparedStatement preparedStatement1 = connection
                            .prepareStatement("UPDATE " + ORDER_TABLE + " SET status=? WHERE id=" + id);
                    preparedStatement1.setString(1, OrderStatus.PENDING_DELIVERY.toString());
                    recordChanged = preparedStatement1.executeUpdate();
                    preparedStatement1.close();
                }
            } else if (orderStatus.equals(OrderStatus.PENDING_DELIVERY.toString())) {
                if (status.equals(OrderStatus.ORDER_DELIVERED.toString())) {
                    PreparedStatement preparedStatement1 = connection
                            .prepareStatement("UPDATE " + ORDER_TABLE + " SET status=? WHERE id=" + id);
                    preparedStatement1.setString(1, OrderStatus.ORDER_DELIVERED.toString());
                    recordChanged = preparedStatement1.executeUpdate();
                    preparedStatement1.close();
                }
            } else {
                System.out.println("The Order is not in " + status + " status");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recordChanged;
    }

    /**
     * Displays the details of an order by ID and status.
     *
     * @param id     The ID of the order to be displayed.
     * @param status The status of the order to be displayed.
     * @return A RetrieveOrderDto object representing the details of the order.
     */
    public OrderResponseDto displayOrderDetail(int id, String status) {
        Order order = null;
        OrderResponseDto orderResponseDto = null;
        try {
            connection = DataBaseConnection.getConnection();
            assert connection != null;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + ORDER_TABLE + " WHERE id=" + id);
            if (resultSet.next()) {
                if (!resultSet.getString("status").equals(status)) {
                    System.out.println("The Order is not in " + status + " status");
                    return null;
                } else {
                    order = new Order(resultSet.getInt("id"), resultSet.getInt("user_id"),
                            resultSet.getDouble("total_cost"), resultSet.getString("email"),
                            resultSet.getString("phone_number"), resultSet.getString("order_location"),
                            resultSet.getString("status"), resultSet.getString("order_on"),
                            resultSet.getString("delivery_on"));
                }
            }
            resultSet.close();
            statement.close();
            List<FoodItemDto> foodItemDtos = new ArrayList<>();
            Statement statement1 = connection.createStatement();
            assert order != null;
            ResultSet resultSet1 = statement1
                    .executeQuery("SELECT * FROM " + ORDER_ITEM_TABLE + " WHERE order_id=" + order.getId());
            while (resultSet1.next()) {
                foodItemDtos.add(new FoodItemDto(resultSet1.getInt("food_item_id"), resultSet1.getInt("quantity"),
                        resultSet1.getDouble("cost")));
            }
            resultSet1.close();
            statement.close();
            for (var foodItemDto : foodItemDtos) {
                Statement statement2 = connection.createStatement();
                ResultSet resultSet2 = statement2
                        .executeQuery("SELECT * FROM food_item WHERE id=" + foodItemDto.getFoodItemId());
                if (resultSet2.next()) {
                   foodItemDto.setFoodItemName(resultSet2.getString("name"));
                }
                resultSet2.close();
                statement2.close();
            }
            orderResponseDto = new OrderResponseDto(order, foodItemDtos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orderResponseDto;
    }
}
