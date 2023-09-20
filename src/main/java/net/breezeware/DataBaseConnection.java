package net.breezeware;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * A utility class for managing database connections.
 */
public class DataBaseConnection {
    /**
     * Get a database connection using JDBC.
     *
     * @return A database connection object or null if an exception occurs.
     */
    public static Connection getConnection(){
        try {
            // Attempt to establish a connection to the SQLite database
            return DriverManager.getConnection("jdbc:sqlite:/home/ram/Project/Github/cos_project/db/cafeteria_service.db");
        }catch (Exception e){
            // Print any exception message to the console and return null
            System.out.println(e.getMessage());
            return null;
        }
    }
}