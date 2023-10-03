package com.booking_house_be.repository;
import com.booking_house_be.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepo extends JpaRepository<Review,Integer> {
}
