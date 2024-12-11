package by.clevertec.autoshow.mapper;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.Category;
import by.clevertec.autoshow.entity.dto.CarAssignDto;
import by.clevertec.autoshow.entity.dto.CarCreateDto;
import by.clevertec.autoshow.entity.dto.CarDto;
import by.clevertec.autoshow.entity.dto.CarUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    Car toCar(CarDto carDto);

    CarDto toCarDto(Car car);

    CarCreateDto toCarCreateDto(Car car);

    CarAssignDto toCarAssignDto(Car car);

    CarUpdateDto carUpdateDto(Car car);

    Car toCar(CarCreateDto carCreateDto);

    Car toCar(CarAssignDto carAssignDto);

    Car toCar(CarUpdateDto carUpdateDto);

    List<CarDto> toCarDtoList(List<Car> cars);

    default Category toCategory(String categoryDto) {
        Category category = new Category();
        category.setName(categoryDto);
        return category;
    }

    default String toStringCategory(Category category) {
        return category.getName();
    }
}
