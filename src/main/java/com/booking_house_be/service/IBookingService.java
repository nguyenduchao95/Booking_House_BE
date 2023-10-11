package com.booking_house_be.service;

import com.booking_house_be.entity.Account;
import com.booking_house_be.entity.Booking;
import com.booking_house_be.entity.House;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    List<Booking> getAllBooking();
    Optional<Booking> getBookingById(int id);
    void save(Booking booking);
    void deleteById(int id);
}
