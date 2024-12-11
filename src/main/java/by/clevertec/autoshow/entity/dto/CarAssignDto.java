package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.NotBlank;

public record CarAssignDto(@NotBlank String showroomId) {
}
