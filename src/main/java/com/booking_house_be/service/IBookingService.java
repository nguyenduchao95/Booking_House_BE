package com.booking_house_be.service;

import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface IBookingService {
    List<Booking> findAllByHouseIdAndStatus(int houseId, String status);
    Booking bookingHouse(Booking booking);
    List<Booking> getAll();
    Page<Booking> getByIdAccount(Pageable pageable , int idAccount);
    Booking findById(int id);
    List<Double> getDailyRevenueByOwnerAndWeek( int ownerId,int month,int year, int startDay,int endDay);
    Page<Booking> findBookingsByOwnerId(@Param("ownerId") int ownerId, Pageable pageable);

    void  save(Booking booking);
}
