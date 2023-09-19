package net.breezeware;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:sqlite:/home/ram/Project/Github/cos_project/db/cafeteria_service.db");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}