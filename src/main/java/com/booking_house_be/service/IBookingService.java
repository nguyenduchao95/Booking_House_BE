package com.booking_house_be.service;

import com.booking_house_be.entity.Booking;

import java.util.List;

public interface IBookingService {
    List<Booking> findAllByHouseId(int houseId);
    Booking bookingHouse(Booking booking);
}
