package com.booking_house_be.service;


import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookingService {
    List<Double> getDailyRevenueByOwnerAndWeek( int ownerId,int month,int year, int startDay,int endDay);
}
