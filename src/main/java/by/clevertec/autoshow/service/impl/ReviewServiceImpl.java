package by.clevertec.autoshow.service.impl;

import by.clevertec.autoshow.entity.Car;
import by.clevertec.autoshow.entity.Client;
import by.clevertec.autoshow.entity.Review;
import by.clevertec.autoshow.entity.dto.ReviewCreateDto;
import by.clevertec.autoshow.entity.dto.ReviewDto;
import by.clevertec.autoshow.entity.dto.ReviewUpdateDto;
import by.clevertec.autoshow.mapper.ReviewMapper;
import by.clevertec.autoshow.repository.CarRepository;
import by.clevertec.autoshow.repository.ClientRepository;
import by.clevertec.autoshow.repository.ReviewRepository;
import by.clevertec.autoshow.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    @Override
    public void saveReview(ReviewCreateDto reviewCreateDto) {
        Review review = reviewMapper.toReview(reviewCreateDto);
        Car car = carRepository.findById(Long.valueOf(reviewCreateDto.carId())).orElseThrow();
        Client client = clientRepository.findById(Long.valueOf(reviewCreateDto.clientId())).orElseThrow();
        review.setCar(car);
        review.setClient(client);
        reviewRepository.save(review);
    }


    @Override
    public List<ReviewDto> findAllReviews() {
        return reviewMapper.toReviewDtoList(reviewRepository.findAll());
    }

    @Override
    public ReviewDto findReviewById(long id) {
        return reviewMapper.toReviewDto(reviewRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteReviewById(long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public ReviewDto updateReview(long id, ReviewUpdateDto reviewUpdateDto) {
        Review review = reviewMapper.toReview(reviewUpdateDto);
        review.setId(id);
        Car car = carRepository.findById(Long.valueOf(reviewUpdateDto.carId())).orElseThrow();
        Client client = clientRepository.findById(Long.valueOf(reviewUpdateDto.clientId())).orElseThrow();
        review.setCar(car);
        review.setClient(client);
        return reviewMapper.toReviewDto(reviewRepository.save(review));
    }


}
