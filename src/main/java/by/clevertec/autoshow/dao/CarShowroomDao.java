package by.clevertec.autoshow.dao;

import by.clevertec.autoshow.entity.CarShowroom;
import by.clevertec.autoshow.exception.DaoException;

import java.util.List;

public interface CarShowroomDao extends CommonDao {

    default List<CarShowroom> findAll() throws DaoException {
        return findAll(CarShowroom.class);
    }

    default CarShowroom findById(long id) throws DaoException {
        return findById(id, CarShowroom.class);
    }

    List<CarShowroom> findAllWithEntityGraph() throws DaoException;

    List<CarShowroom> findAllWithJoinFetch() throws DaoException;
}
