package by.clevertec.autoshow.controller;

import by.clevertec.autoshow.entity.dto.CarCreateDto;
import by.clevertec.autoshow.entity.dto.CarDto;
import by.clevertec.autoshow.entity.dto.CarShowroomAssignDto;
import by.clevertec.autoshow.entity.dto.CarUpdateDto;
import by.clevertec.autoshow.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
@Validated
public class CarController {

    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCar(@RequestBody @Valid CarCreateDto car) {
        carService.saveCar(car);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto updateCar(@PathVariable("id") @Valid @NotBlank long id,
                            @RequestBody @Valid CarUpdateDto car) {
        return carService.updateCar(id, car);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto assignCar(@PathVariable("id") @Valid @NotBlank long id,
                            @RequestBody @Valid @NotBlank CarShowroomAssignDto showroom) {
        return carService.assignCarToShowroom(id, showroom);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CarDto getCarByID(@PathVariable("id") @Valid @NotBlank long id) {
        return carService.findCarById(id);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDto> getCars() {
        return carService.findAllCars();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("id") @Valid @NotBlank long id) {
        carService.deleteCarById(id);
    }
}
