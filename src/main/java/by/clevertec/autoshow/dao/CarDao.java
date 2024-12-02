package by.clevertec.autoshow.dao;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.exception.DaoException;
import jakarta.persistence.QueryHint;
import org.hibernate.jpa.AvailableHints;

import java.util.List;

public interface CarDao extends CommonDao {

    default List<Car> findAll() throws DaoException {
        return findAll(Car.class);
    }

    default Car findById(long id) throws DaoException {
        return findById(id, Car.class);
    }

    List<Car> findCarsByFilters(String brand, String category, int year, double minPrice, double maxPrice) throws DaoException;

    List<Car> findAllCarsOrderByPriceAsc() throws DaoException;

    List<Car> findAllCarsOrderByPriceDesc() throws DaoException;

    List<Car> findAllCars(int pageNumber, int pageSize) throws DaoException;
}
