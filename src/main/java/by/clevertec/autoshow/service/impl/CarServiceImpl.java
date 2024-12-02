package by.clevertec.autoshow.service.impl;

import by.clevertec.autoshow.dao.CarDao;
import by.clevertec.autoshow.dao.impl.CarDaoImpl;
import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.CarShowroom;
import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.exception.ServiceException;
import by.clevertec.autoshow.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public void addCar(Car car) throws ServiceException {
        CarDao carDao = CarDaoImpl.getInstance();
        try {
            carDao.save(car);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Car> findCarsByFilters(String brand, String category, int year, double minPrice, double maxPrice) throws ServiceException {
        CarDao carDao = CarDaoImpl.getInstance();
        try {
            return carDao.findCarsByFilters(brand, category, year, minPrice, maxPrice);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void assignCarToShowroom(Car car, CarShowroom carShowroom) throws ServiceException {
        CarDao carDao = CarDaoImpl.getInstance();
        car.setCarShowroom(carShowroom);
        try {
            carDao.update(car);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Car> findAllCarsOrderByPriceAsc() throws ServiceException {
        CarDao carDao = CarDaoImpl.getInstance();
        try {
            return carDao.findAllCarsOrderByPriceAsc();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Car> findAllCarsOrderByPriceDesc() throws ServiceException {
        CarDao carDao = CarDaoImpl.getInstance();
        try {
            return carDao.findAllCarsOrderByPriceDesc();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Car> findAllCars(int pageNumber, int pageSize) throws ServiceException {
        CarDao carDao = CarDaoImpl.getInstance();
        try {
            return carDao.findAllCars(pageNumber, pageSize);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
