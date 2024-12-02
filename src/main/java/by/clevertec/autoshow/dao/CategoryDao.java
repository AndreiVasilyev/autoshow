package by.clevertec.autoshow.dao;

import by.clevertec.autoshow.entity.Category;
import by.clevertec.autoshow.exception.DaoException;

import java.util.List;

public interface CategoryDao extends CommonDao {

    default List<Category> findAll() throws DaoException {
        return findAll(Category.class);
    }

    default Category findById(long id) throws DaoException {
        return findById(id, Category.class);
    }
}
