package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CategoryUpdateDto(@NotBlank @Positive Long id, String name) {
}
