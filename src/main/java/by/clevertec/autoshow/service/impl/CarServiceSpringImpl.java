package by.clevertec.autoshow.service.impl;

import by.clevertec.autoshow.entity.dto.CarAssignDto;
import by.clevertec.autoshow.entity.dto.CarCreateDto;
import by.clevertec.autoshow.entity.dto.CarDto;
import by.clevertec.autoshow.entity.dto.CarUpdateDto;
import by.clevertec.autoshow.mapper.CarMapper;
import by.clevertec.autoshow.repository.CarRepository;
import by.clevertec.autoshow.service.CarServiceSpring;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceSpringImpl implements CarServiceSpring {

    private final CarRepository carRepository;
    private final CarMapper carMapper;


    @Override
    public void saveCar(CarCreateDto car) {
        carRepository.save(carMapper.toCar(car));
    }

    @Override
    public CarDto assignCarToShowroom(long id, CarAssignDto car) {
        //TODO create method in repo
        return null;
    }

    @Override
    public List<CarDto> findAllCars() {
        return carMapper.toCarDtoList(carRepository.findAll());
    }

    @Override
    public CarDto findCarById(long id) {
        return carMapper.toCarDto(carRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    @Transactional
    @Override
    public CarDto updateCar(long id, CarUpdateDto car) {
        return carMapper.toCarDto(carRepository.save(carMapper.toCar(car)));
    }
}
