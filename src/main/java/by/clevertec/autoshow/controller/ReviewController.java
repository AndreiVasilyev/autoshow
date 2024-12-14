package by.clevertec.autoshow.controller;

import by.clevertec.autoshow.entity.dto.ReviewCreateDto;
import by.clevertec.autoshow.entity.dto.ReviewDto;
import by.clevertec.autoshow.entity.dto.ReviewUpdateDto;
import by.clevertec.autoshow.service.ReviewService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Validated
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveClient(@RequestBody @Valid ReviewCreateDto review) {
        reviewService.saveReview(review);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDto updateClient(@PathVariable("id") @Valid @NotBlank long id,
                                  @RequestBody @Valid ReviewUpdateDto review) {
        return reviewService.updateReview(id, review);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ReviewDto getReviewByID(@PathVariable("id") @Valid @NotBlank long id) {
        return reviewService.findReviewById(id);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewDto> getReviews() {
        return reviewService.findAllReviews();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable("id") @Valid @NotBlank long id) {
        reviewService.deleteReviewById(id);
    }
}
