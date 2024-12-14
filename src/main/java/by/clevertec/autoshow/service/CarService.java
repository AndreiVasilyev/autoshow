package by.clevertec.autoshow.service;

import by.clevertec.autoshow.entity.dto.CarAssignDto;
import by.clevertec.autoshow.entity.dto.CarCreateDto;
import by.clevertec.autoshow.entity.dto.CarDto;
import by.clevertec.autoshow.entity.dto.CarShowroomAssignDto;
import by.clevertec.autoshow.entity.dto.CarUpdateDto;

import java.util.List;

public interface CarService {

    void saveCar(CarCreateDto car) ;

    CarDto assignCarToShowroom(long id, CarShowroomAssignDto carShowroom);

    List<CarDto> findAllCars() ;

    CarDto findCarById(long id) ;

    void deleteCarById(long id) ;

    CarDto updateCar(long id, CarUpdateDto car);

}
