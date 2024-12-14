package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.Positive;

public record ReviewUpdateDto(String text, @Positive String rate,
                              @Positive String carId, @Positive String clientId) {
}
