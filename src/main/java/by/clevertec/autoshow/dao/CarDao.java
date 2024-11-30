package by.clevertec.autoshow.dao;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.exception.DaoException;

import java.util.List;

public interface CarDao extends CommonDao {

    default List<Car> findAll() throws DaoException {
        return findAll(Car.class);
    }

    default Car findById(long id) throws DaoException {
        return findById(id, Car.class);
    }
}
