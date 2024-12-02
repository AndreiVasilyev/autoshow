package by.clevertec.autoshow.service;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.entity.Review;
import by.clevertec.autoshow.exception.ServiceException;

import java.util.List;

public interface ReviewService {

    void addReview(Client client, Car car, String text, int rate) throws ServiceException;

    List<Review> searchReviews(String keyword) throws ServiceException;

    List<Review> searchReviews(int rate) throws ServiceException;
}
