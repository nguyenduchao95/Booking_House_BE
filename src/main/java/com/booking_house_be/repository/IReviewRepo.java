package com.booking_house_be.repository;
import com.booking_house_be.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReviewRepo extends JpaRepository<Review,Integer> {
    @Query("SELECT r FROM Review r WHERE r.booking.house.id = :houseId")
    List<Review> findAllByHouseId(@Param("houseId") int houseId);

    @Query("SELECT AVG (r.rating) FROM Review r WHERE r.booking.house.id = :houseId")
    Double avgRating(@Param("houseId") int houseId);
}
