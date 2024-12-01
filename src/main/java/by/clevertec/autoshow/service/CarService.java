package by.clevertec.autoshow.service;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.CarShowroom;
import by.clevertec.autoshow.exception.ServiceException;

import java.util.List;

public interface CarService {

    void addCar(Car car) throws ServiceException;

    List<Car> findCarsByFilters(String brand, String category, int year, double minPrice, double maxPrice) throws ServiceException;

    void assignCarToShowroom(Car car, CarShowroom carShowroom) throws ServiceException;

    List<Car> findAllCarsOrderByPriceAsc() throws ServiceException;

    List<Car> findAllCarsOrderByPriceDesc() throws ServiceException;

    List<Car> findAllCars(int pageNumber, int pageSize) throws ServiceException;
}
