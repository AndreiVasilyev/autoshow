package by.clevertec.autoshow.entity.dto;

public record CarUpdateDto(String model, String brand, String year, String price, CategoryUpdateDto category) {
}
