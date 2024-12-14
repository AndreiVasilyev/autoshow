package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CategoryDto(@NotBlank @Positive Long id, String name) {
}
