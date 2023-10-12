package com.booking_house_be.service;



import com.booking_house_be.entity.Booking;

import java.util.List;
import java.util.Optional;


public interface IBookingService {
    List<Booking> getAllBooking();
    Optional<Booking> getBookingById(int id);
    void save(Booking booking);
    void deleteById(int id);

    List<Double> getDailyRevenueByOwnerAndWeek( int ownerId,int month,int year, int startDay,int endDay);
}
