package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CarShowroomAssignDto(@NotBlank @Positive long id) {
}
