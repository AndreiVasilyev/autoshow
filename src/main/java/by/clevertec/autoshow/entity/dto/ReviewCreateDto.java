package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ReviewCreateDto(@NotBlank String text, @NotBlank @Positive String rate,
                              @Positive String carId, @Positive String clientId) {
}
