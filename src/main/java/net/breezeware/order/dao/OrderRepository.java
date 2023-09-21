package net.breezeware.order.dao;

import net.breezeware.DataBaseConnection;
import net.breezeware.food.enumeration.Days;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    Connection connection;
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
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
