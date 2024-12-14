package by.clevertec.autoshow.service.impl;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.CarShowroom;
import by.clevertec.autoshow.entity.Category;
import by.clevertec.autoshow.entity.dto.CarCreateDto;
import by.clevertec.autoshow.entity.dto.CarDto;
import by.clevertec.autoshow.entity.dto.CarShowroomAssignDto;
import by.clevertec.autoshow.entity.dto.CarUpdateDto;
import by.clevertec.autoshow.mapper.CarMapper;
import by.clevertec.autoshow.mapper.CategoryMapper;
import by.clevertec.autoshow.postprocessor.InjectParamsLogging;
import by.clevertec.autoshow.repository.CarRepository;

import by.clevertec.autoshow.repository.CarShowroomRepository;
import by.clevertec.autoshow.repository.CategoryRepository;
import by.clevertec.autoshow.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@InjectParamsLogging
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CategoryRepository categoryRepository;
    private final CarShowroomRepository carShowroomRepository;
    private final CarMapper carMapper;
    private final CategoryMapper categoryMapper;

    @Transactional
    @Override
    public void saveCar(CarCreateDto carDto) {
        Category category = categoryRepository.findByName(carDto.category().name());
        if (category == null) {
            categoryRepository.save(categoryMapper.toCategory(carDto.category()));
        }
        Car car = carMapper.toCar(carDto);
        car.setCategory(categoryRepository.findByName(carDto.category().name()));
        carRepository.save(car);
    }

    @Override
    public CarDto assignCarToShowroom(long id, CarShowroomAssignDto carShowroomDto) {
        Car car =carRepository.findById(id).orElseThrow();
        CarShowroom carShowroom=carShowroomRepository.findById(carShowroomDto.id()).orElseThrow();
        car.setCarShowroom(carShowroom);
        carRepository.save(car);
        return carMapper.toCarDto(car);
    }

    @Override
    public List<CarDto> findAllCars() {
        return carMapper.toCarDtoList(carRepository.findAll());
    }

    @Override
    public CarDto findCarById(long id) {
        return carMapper.toCarDto(carRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteCarById(long id) {
        carRepository.deleteById(id);
    }

    @Transactional
    @Override
    public CarDto updateCar(long id, CarUpdateDto carUpdateDto) {
        Car car = carMapper.toCar(carUpdateDto);
        car.setId(id);
        return carMapper.toCarDto(carRepository.save(car));
    }
}
