package by.clevertec.autoshow.mapper;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.dto.CarAssignDto;
import by.clevertec.autoshow.entity.dto.CarBuyDto;
import by.clevertec.autoshow.entity.dto.CarCreateDto;
import by.clevertec.autoshow.entity.dto.CarDto;
import by.clevertec.autoshow.entity.dto.CarUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto toCarDto(Car car);

    Car toCar(CarCreateDto carCreateDto);

    Car toCar(CarUpdateDto carUpdateDto);

    List<CarDto> toCarDtoList(List<Car> cars);

}
