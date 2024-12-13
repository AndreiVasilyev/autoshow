package by.clevertec.autoshow.service;

import by.clevertec.autoshow.entity.dto.CategoryCreateDto;
import by.clevertec.autoshow.entity.dto.CategoryDto;

public interface CategoryServiceSpring {

    void addCategory(CategoryCreateDto categoryCreateDto);

    CategoryDto getCategoryByName(String name);
}
