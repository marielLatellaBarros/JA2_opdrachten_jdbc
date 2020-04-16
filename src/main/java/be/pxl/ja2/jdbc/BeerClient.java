package be.pxl.ja2.jdbc;

import be.pxl.ja2.jdbc.dao.Beer;
import be.pxl.ja2.jdbc.dao.BeerDAO;
import be.pxl.ja2.jdbc.dao.BeerDAOImpl;
import be.pxl.ja2.jdbc.dao.BeerException;

/**
 * Exercise 8: Use Data Access Objects to get and update data from database
 */
public class BeerClient {

    public static void main(String[] args) throws BeerException {

        BeerDAO beerDAO = new BeerDAOImpl("jdbc:mariadb://localhost:3307/studentdb", "user", "password");

        Beer beer = beerDAO.getId(10);

        System.out.println(beer.getName());
        System.out.println(beer.getPrice());
        System.out.println(beer.getAlcohol());
        System.out.println(beer.getStock());

        beer.setStock(beer.getStock() - 10);
        beerDAO.update(beer);
    }
}
