package by.clevertec.autoshow.entity.dto;

import java.util.Set;

public record ClientUpdateDto(String name, String registered, Set<String> contacts) {
}
