package by.clevertec.autoshow.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

public record ClientCreateDto(@NotBlank String name,
                              @NotBlank @Pattern(regexp = "[0-3]?\\d\\.[0-1]?\\d\\.(19|20)\\d{2}") String registered,
                              Set<String> contacts) {
}
