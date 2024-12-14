package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CarDto(@NotBlank @Positive String id, String model, String brand, @Min(value = 1900) String year,
                     @Positive String price, CategoryDto category) {
}
