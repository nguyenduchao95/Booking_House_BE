package com.booking_house_be.service;

import com.booking_house_be.entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookingService {
    List<Booking> getAll();
    Page<Booking> getByIdAccount(Pageable pageable , int idAccount);
    Booking findById(int id);
}
