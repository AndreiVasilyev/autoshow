package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public record CarUpdateDto(String model, String brand, @Min(value = 1900) String year, @Positive String price, CategoryUpdateDto category) {
}
