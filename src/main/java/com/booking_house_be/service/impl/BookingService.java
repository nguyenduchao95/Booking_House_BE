package com.booking_house_be.service.impl;
import com.booking_house_be.entity.Account;
import com.booking_house_be.entity.Booking;
import com.booking_house_be.repository.IBookingRepo;
import com.booking_house_be.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private IBookingRepo bookingRepo;
    @Autowired
    private EmailService emailService;
    @Autowired
    private AccountService accountService;

    @Override
    public List<Booking> findAllByHouseId(int houseId) {
        return bookingRepo.findAllByHouseId(houseId);
    }

    @Override
    public Booking bookingHouse(Booking booking) {
        Account account = accountService.getById(booking.getAccount().getId());
        booking.setAccount(account);
        try {
            emailService.sendBill(account.getEmail(), booking);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bookingRepo.save(booking);
    }
}