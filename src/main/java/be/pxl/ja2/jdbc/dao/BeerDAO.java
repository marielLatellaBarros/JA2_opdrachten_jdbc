package be.pxl.ja2.jdbc.dao;

public interface BeerDAO {

    Beer getId(int id) throws BeerException;

    void update(Beer beer) throws BeerException;

    Beer getName(String name);

    boolean delete(long id);

    Beer create(Beer beer);
}
