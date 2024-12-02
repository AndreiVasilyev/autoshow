package by.clevertec.autoshow.service.impl;

import by.clevertec.autoshow.dao.ClientDao;
import by.clevertec.autoshow.dao.ReviewDao;
import by.clevertec.autoshow.dao.impl.ClientDaoImpl;
import by.clevertec.autoshow.dao.impl.ReviewDaoImpl;
import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.entity.Review;
import by.clevertec.autoshow.exception.DaoException;
import by.clevertec.autoshow.exception.ServiceException;
import by.clevertec.autoshow.service.ReviewService;


import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Override
    public void addReview(Client client, Car car, String text, int rate) throws ServiceException {
        ReviewDao reviewDao = ReviewDaoImpl.getInstance();
        Review review = Review.builder()
                .text(text)
                .rate(rate)
                .car(car)
                .client(client)
                .build();
        try {
            reviewDao.save(review);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Review> searchReviews(String keyword) throws ServiceException {
        ReviewDao reviewDao = ReviewDaoImpl.getInstance();
        try {
            return reviewDao.findByText(keyword);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Review> searchReviews(int rate) throws ServiceException {
        ReviewDao reviewDao = ReviewDaoImpl.getInstance();
        try {
            return reviewDao.findByRate(rate);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
