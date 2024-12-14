package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ReviewDto(@NotBlank @Positive String id, String text, @Positive String rate) {
}
