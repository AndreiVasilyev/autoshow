package by.clevertec.autoshow.service;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.CarShowroom;
import by.clevertec.autoshow.entity.dto.CarAssignDto;
import by.clevertec.autoshow.entity.dto.CarCreateDto;
import by.clevertec.autoshow.entity.dto.CarDto;
import by.clevertec.autoshow.entity.dto.CarUpdateDto;
import by.clevertec.autoshow.exception.ServiceException;

import java.util.List;

public interface CarServiceSpring {

    void saveCar(CarCreateDto car) ;

    CarDto assignCarToShowroom(long id, CarAssignDto car);

    List<CarDto> findAllCars() ;

    CarDto findCarById(long id) ;

    void deleteCarById(long id) ;

    CarDto updateCar(long id, CarUpdateDto car);

}
