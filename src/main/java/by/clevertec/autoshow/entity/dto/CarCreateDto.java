package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CarCreateDto(@NotBlank String model, @NotBlank String brand,
                           @NotBlank @Min(value = 1900) String year, @NotBlank @Positive String price,
                           CategoryCreateDto category) {
}