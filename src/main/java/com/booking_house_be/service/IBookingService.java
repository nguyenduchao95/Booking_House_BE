package com.booking_house_be.service;

import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBookingService {
    List<Booking> getAll();
    Page<Booking> getByIdAccount(Pageable pageable , int idAccount);
    Booking findById(int id);
    List<Double> getDailyRevenueByOwnerAndWeek( int ownerId,int month,int year, int startDay,int endDay);
    Page<Booking> findBookingsByOwnerId(@Param("ownerId") int ownerId, Pageable pageable);
    void  save(Booking booking);

    Page<Booking> findByHouseAndStartTimeAndEndTimeAndStatus(
            int ownerId, String nameSearch, String status, int yearStart,
            int monthStart, int dayStart,int yearEnd, int monthEnd, int dayEnd, Pageable pageable);
    Page<Booking> findByHouseAndStatus(int ownerId, String nameSearch, String status, Pageable pageable );

}
