package be.pxl.ja2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Exercise 3: Update values in database directly from app
 */
public class ChangeStock {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3307/studentdb", "user", "password");) {

            Statement statement = connection.createStatement();
            String query = "UPDATE Beers SET Stock = 50 WHERE Name LIKE '%kriek%' ";
            int updatedStock = statement.executeUpdate(query); {
                System.out.println("Number of beers updated: " + updatedStock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
