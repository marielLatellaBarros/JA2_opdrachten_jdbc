package be.pxl.ja2.jdbc;

import java.sql.*;
/**
 * Exercise 5: Search using prepared statements
 */
public class PreparedStatement_SearchBeer {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3307/studentdb", "user", "password");) {
            
            String query = "SELECT Name FROM Beers WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 10);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String beerName = resultSet.getString(1);
                System.out.printf("%s", beerName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
