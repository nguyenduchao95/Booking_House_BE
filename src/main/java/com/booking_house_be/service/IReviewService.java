package com.booking_house_be.service;

import com.booking_house_be.entity.Review;

import java.util.List;

public interface IReviewService {
    List<Review> findAllByHouseId(int houseId);

    Double avgRating(int houseId);
}
