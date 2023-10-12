package com.booking_house_be.service;

import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


import com.booking_house_be.entity.Booking;

import java.util.List;
import java.util.Optional;


public interface IBookingService {
    List<Booking> getAllBooking();
    void save(Booking booking);
    void deleteById(int id);

    List<Booking> getAll();
    Page<Booking> getByIdAccount(Pageable pageable , int idAccount);
    Booking findById(int id);
    List<Double> getDailyRevenueByOwnerAndWeek( int ownerId,int month,int year, int startDay,int endDay);

}
