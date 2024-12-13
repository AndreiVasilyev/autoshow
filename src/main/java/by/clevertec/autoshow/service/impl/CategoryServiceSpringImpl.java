package by.clevertec.autoshow.service.impl;

import by.clevertec.autoshow.entity.dto.CategoryCreateDto;
import by.clevertec.autoshow.entity.dto.CategoryDto;
import by.clevertec.autoshow.mapper.CategoryMapper;
import by.clevertec.autoshow.repository.CategoryRepository;
import by.clevertec.autoshow.service.CategoryServiceSpring;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceSpringImpl implements CategoryServiceSpring {


    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public void addCategory(CategoryCreateDto categoryCreateDto) {
        categoryRepository.save(categoryMapper.toCategory(categoryCreateDto));
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return categoryMapper.toCategoryDto(categoryRepository.findByName(name));
    }
}
