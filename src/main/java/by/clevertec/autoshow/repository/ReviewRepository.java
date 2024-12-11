package by.clevertec.autoshow.repository;

import by.clevertec.autoshow.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
