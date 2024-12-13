package by.clevertec.autoshow.service;

import by.clevertec.autoshow.entity.dto.ReviewCreateDto;
import by.clevertec.autoshow.entity.dto.ReviewDto;
import by.clevertec.autoshow.entity.dto.ReviewUpdateDto;

import java.util.List;

public interface ReviewServiceSpring {

    void saveReview(ReviewCreateDto reviewCreateDto);

    List<ReviewDto> findAllReviews();

    ReviewDto findReviewById(long id);

    void deleteReviewById(long id);

    ReviewDto updateReview(long id, ReviewUpdateDto reviewUpdateDto);

}
