package by.clevertec.autoshow.entity.dto;

import java.util.Set;

public record ClientCreateDto(String name, String registered, Set<String> contacts) {
}
