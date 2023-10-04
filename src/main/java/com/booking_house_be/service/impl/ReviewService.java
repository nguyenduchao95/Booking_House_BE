package com.booking_house_be.service.impl;

import com.booking_house_be.entity.Review;
import com.booking_house_be.repository.IReviewRepo;
import com.booking_house_be.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    private IReviewRepo reviewRepo;

    @Override
    public List<Review> findAllByHouseId(int houseId) {
        return reviewRepo.findAllByHouseId(houseId);
    }

    @Override
    public Double avgRating(int houseId) {
        Double avg = reviewRepo.avgRating(houseId);
        return Math.round(avg * 10) / 10.0;
    }
}
