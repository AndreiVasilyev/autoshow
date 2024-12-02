package by.clevertec.autoshow.dao;

import by.clevertec.autoshow.entity.Review;
import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.exception.ServiceException;

import java.util.List;

public interface ReviewDao extends CommonDao {

    default List<Review> findAll() throws DaoException {
        return findAll(Review.class);
    }

    default Review findById(long id) throws DaoException {
        return findById(id, Review.class);
    }

    List<Review> findByText(String keyword) throws DaoException;

    List<Review> findByRate(int rate) throws DaoException;
}
