package by.clevertec.autoshow.mapper;

import by.clevertec.autoshow.entity.Category;
import by.clevertec.autoshow.entity.dto.CategoryCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryCreateDto categoryCreateDto);
}
