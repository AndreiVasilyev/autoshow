package by.clevertec.autoshow.entity.dto;

import java.util.Set;

public record ClientDto(String id, String name, String registered, Set<String> contacts) {
}
