package by.clevertec.autoshow.mapper;

import by.clevertec.autoshow.entity.Review;
import by.clevertec.autoshow.entity.dto.ReviewCreateDto;
import by.clevertec.autoshow.entity.dto.ReviewDto;
import by.clevertec.autoshow.entity.dto.ReviewUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review toReview(ReviewDto reviewDto);

    ReviewDto toReviewDto(Review review);

    Review toReview(ReviewCreateDto reviewCreateDto);

    ReviewCreateDto toReviewCreateDto(Review review);

    Review toReview(ReviewUpdateDto reviewUpdateDto);

    ReviewUpdateDto toReviewUpdateDto(Review review);

    List<ReviewDto> toReviewDtoList(List<Review> reviews);

}
