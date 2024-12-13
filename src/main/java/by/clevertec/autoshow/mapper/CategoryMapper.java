package by.clevertec.autoshow.mapper;

import by.clevertec.autoshow.entity.Category;
import by.clevertec.autoshow.entity.dto.CategoryCreateDto;
import by.clevertec.autoshow.entity.dto.CategoryDto;
import by.clevertec.autoshow.entity.dto.CategoryUpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryCreateDto categoryCreateDto);

    CategoryCreateDto toCategoryCreateDto(Category category);

    Category toCategory(CategoryDto categoryDto);

    CategoryDto toCategoryDto(Category category);

    Category toCategory(CategoryUpdateDto categoryUpdateDto);

    CategoryUpdateDto toCategoryUpdateDto(Category category);


}
