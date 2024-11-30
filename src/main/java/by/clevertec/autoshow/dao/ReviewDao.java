package by.clevertec.autoshow.dao;

import by.clevertec.autoshow.entity.Review;
import by.clevertec.autoshow.exception.DaoException;

import java.util.List;

public interface ReviewDao extends CommonDao {

    default List<Review> findAll() throws DaoException {
        return findAll(Review.class);
    }

    default Review findById(long id) throws DaoException {
        return findById(id, Review.class);
    }
}
