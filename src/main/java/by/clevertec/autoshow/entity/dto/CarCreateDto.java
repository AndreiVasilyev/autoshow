package by.clevertec.autoshow.entity.dto;

public record CarCreateDto(String model, String brand, String year, String price, CategoryCreateDto category) {
}