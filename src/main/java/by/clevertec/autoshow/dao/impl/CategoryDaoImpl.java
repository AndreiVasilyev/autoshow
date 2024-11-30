package by.clevertec.autoshow.dao.impl;

import by.clevertec.autoshow.dao.CategoryDao;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDaoImpl implements CategoryDao {

    @Getter
    private static final CategoryDao instance = new CategoryDaoImpl();

}
