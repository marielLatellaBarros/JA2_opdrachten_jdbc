package be.pxl.ja2.jdbc;

import java.sql.*;
/**
 * Exercise 4: Add values in database directly from app
 */
public class AddBeer {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3307/studentdb", "user", "password");) {

            Statement statement = connection.createStatement();
            String query = "INSERT INTO Beers(Name, BrewerId, CategoryId, Alcohol, Price, Stock)" +
                    "VALUES ('MyBeer', 14, 6, 12, 3, 100)";
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    System.out.println("The new record Id is: " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
