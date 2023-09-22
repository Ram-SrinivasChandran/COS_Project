package net.breezeware.order.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.enumeration.Days;
import net.breezeware.order.enumeration.OrderStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderRepository {
    Connection connection;
    public static final String TABLE_NAME_ORDER="order";
    public void viewFoodMenu(Days day){
        List<Integer>foodMenuIds=new ArrayList<>();
        try{
            connection= DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM food_menu WHERE availabilityOn='"+ day+"'");
            while(resultSet.next()){
                foodMenuIds.add(resultSet.getInt("id"));
            }
            resultSet.close();
            statement.close();
            for (var foodMenuId:
                 foodMenuIds) {
                Statement statement3=connection.createStatement();
                ResultSet resultSet3=statement3.executeQuery("SELECT * FROM food_menu WHERE id="+foodMenuId);
                if(resultSet3.next()){
                    System.out.println("Id : "+resultSet3.getInt("id")+
                            ", Name: "+resultSet3.getString("name")+
                            ", Type : "+resultSet3.getString("type")+
                            ", AvailabilityOn : "+resultSet3.getString("availabilityOn"));
                }
                resultSet3.close();
                statement3.close();
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("SELECT * FROM food_menu_food_item_map WHERE food_menu_id=" + foodMenuId);
                List<Integer>foodItemId=new ArrayList<>();
                while (resultSet1.next()) {
                    foodItemId.add(resultSet1.getInt("food_item_id"));
                }
                resultSet1.close();
                statement1.close();
                for (var foodItem :
                        foodItemId) {
                    Statement statement2 = connection.createStatement();
                    ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM food_Item WHERE id=" + foodItem);
                    if (resultSet2.next()) {
                        System.out.println("     Id : " + resultSet2.getInt("id") +
                                ", Name : " + resultSet2.getString("name") +
                                ", Cost : " + resultSet2.getDouble("cost") +
                                ", Quantity : " + resultSet2.getInt("quantity"));
                    }
                    resultSet2.close();
                    statement2.close();
                }
                connection.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public boolean userCheck(int userId){
        boolean checkUser=false;
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM user WHERE id='"+userId+"'");
            if(resultSet.next()){
                   if(resultSet.getString("role").equals("Customer")){
                       checkUser=true;
                   }
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return checkUser;
    }
    public void orderInCart(int orderId,int userId){
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            PreparedStatement statement=connection.prepareStatement("INSERT INTO \""+TABLE_NAME_ORDER+"\" (id,user_id,status) VALUES (?,?,?)");
            statement.setInt(1,orderId);
            statement.setInt(2,userId);
            statement.setString(3, String.valueOf(OrderStatus.IN_CART));
            statement.execute();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void viewOrder(int orderId){
        try{
            connection=DataBaseConnection.getConnection();
            assert connection!=null;
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM \""+TABLE_NAME_ORDER+"\" WHERE id="+orderId);
            if(resultSet.next()){
                System.out.println("Id : "+resultSet.getInt("id")+
                        ", User Id : "+resultSet.getInt("user_id")+
                        ", Total Cost : "+resultSet.getDouble("total_cost")+
                        ", Status : "+resultSet.getString("status"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
