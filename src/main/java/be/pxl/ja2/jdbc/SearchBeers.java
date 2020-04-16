package be.pxl.ja2.jdbc;

import java.sql.*;

public class SearchBeers {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3307/studentdb", "user", "password");) {

			Statement statement = connection.createStatement();
			String query = "SELECT * FROM Beers WHERE Alcohol <= 9 AND BrewerId = 33 ORDER BY Alcohol";

			ResultSet resultSet = statement.executeQuery(query); {
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
					System.out.printf("%d %s %d %d %.1f %d %.2f  %d%n",
							id, beerName, brewerId, categoryId, price, stock, alcohol, version);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
