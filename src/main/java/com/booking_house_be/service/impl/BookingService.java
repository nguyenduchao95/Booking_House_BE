package com.booking_house_be.service.impl;
import com.booking_house_be.entity.Booking;
import com.booking_house_be.repository.IBookingRepo;
import com.booking_house_be.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBookingService {

    @Autowired
    private IBookingRepo bookingRepo;
    @Override
    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }

    @Override
    public Page<Booking> getByIdAccount(Pageable pageable , int idAccount) {
        return bookingRepo.getByIdAccount(pageable  , idAccount);
    }

    @Override
    public Booking findById(int id) {
        return bookingRepo.findById(id);
    }
}