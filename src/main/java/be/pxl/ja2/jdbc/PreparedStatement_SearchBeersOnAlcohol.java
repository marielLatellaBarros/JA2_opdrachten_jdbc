package be.pxl.ja2.jdbc;

import java.sql.*;

/**
 * Exercise 5: Search using prepared statements
 */
public class PreparedStatement_SearchBeersOnAlcohol {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3307/studentdb", "user", "password");) {
            
            String query = "SELECT * FROM Beers WHERE Alcohol <= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 2);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String beerName = resultSet.getString(2);
                int brewerId = resultSet.getInt(3);
                int categoryId = resultSet.getInt(4);
                double price = resultSet.getFloat(5);
                int stock = resultSet.getInt(6);
                double alcohol = resultSet.getFloat(7);
                int version = resultSet.getInt(8);
                Blob image = resultSet.getBlob(9);
                System.out.printf("%d %s %d %d %.1f %d %.0f percent  %d%n",
                        id, beerName, brewerId, categoryId, price, stock, alcohol, version);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
