package be.pxl.ja2.jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeerDAOImpl implements BeerDAO {

    private final String url;
    private final String user;
    private final String password;

    public BeerDAOImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public Beer getId(int id) throws BeerException {
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM Beers WHERE Id = ?")) {
            stmt.setInt(1,id);

            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Beer beer = new Beer();
                    beer.setId(id);
                    beer.setName(rs.getString("Name"));
                    beer.setPrice(rs.getFloat("Price"));
                    beer.setAlcohol(rs.getFloat("Alcohol"));
                    beer.setStock(rs.getInt("Stock"));
                    return beer;
                } else{
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new BeerException(e);
        }
    }

    @Override
    public void update(Beer beer) throws BeerException {
        try(Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE Beers SET Name=?, Price=?, Alcohol=?, Stock=? WHERE ID = ?")) {

            stmt.setInt(5,beer.getId());
            stmt.setInt(4,beer.getStock());
            stmt.setFloat(3,beer.getAlcohol());
            stmt.setFloat(2,beer.getPrice());
            stmt.setString(1,beer.getName());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new BeerException(e);
        }
    }
    //TODO: implement method
    public List<Beer> getBeersByAlcohol(float alcohol){
        return new ArrayList<>();
    }

    //TODO: implement method
    public List<Beer> getBeersByName(String name){
        return new ArrayList<>();
    }

    @Override
    public Beer getName(String name) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public Beer create(Beer beer) {
        return null;
    }

    //Private helper methods
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
