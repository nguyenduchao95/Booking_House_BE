package com.booking_house_be.service.impl;

import com.booking_house_be.entity.Account;
import com.booking_house_be.entity.Booking;
import com.booking_house_be.repository.IBookingRepo;
import com.booking_house_be.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private IBookingRepo bookingRepo;
    @Autowired
    private EmailService emailService;
    @Autowired
    private AccountService accountService;

    @Override
    public List<Booking> findAllByHouseIdAndStatus(int houseId) {
        return bookingRepo.findAllByHouseIdAndStatus(houseId);
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
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return bookingRepo.save(booking);
    }

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepo.findAll();
    }

    @Override
    public void save(Booking booking) {
        bookingRepo.save(booking);
    }

    @Override
    public void deleteById(int id) {
        bookingRepo.deleteById(id);
    }
    @Override
    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }
    @Override
    public List<Double> getDailyRevenueByOwnerAndWeek(int ownerId,int month,int year, int startDay,int endDay) {
        return this.getDailyRevenuesByOwnerAndWeek( ownerId, month, year,  startDay, endDay);
    }

    @Override
    public Page<Booking> findByHouseAndStartTimeAndEndTimeAndStatus(int ownerId, String nameSearch, String status, LocalDateTime startTime, LocalDateTime endTime, Pageable pageable) {
        return bookingRepo.findByHouseAndStartTimeAndEndTimeAndStatus(ownerId,nameSearch,status,startTime,endTime,pageable);
    }

    List<Double> getDailyRevenuesByOwnerAndWeek(int ownerId, int year, int month, int startDay, int endDay) {
        List<Object[]> result = bookingRepo.getDailyRevenueByOwnerAndWeek(ownerId, year, month, startDay, endDay);
        List<Double> dailyRevenues = new ArrayList<>();
        for (int day = startDay; day <= endDay; day++) {
            boolean found = false;
            for (Object[] row : result) {
                int rowDay = (int) row[0];
                double revenue = (double) row[1];

                if (rowDay == day) {
                    dailyRevenues.add(revenue);
                    found = true;
                    break;
                }
            }
            if (!found) {
                dailyRevenues.add(0.0);
            }
        }
        return dailyRevenues;
    }



    @Override
    public Page<Booking> getByIdAccount(Pageable pageable , int idAccount) {
        return bookingRepo.getByIdAccount(pageable  , idAccount);
    }

    @Override
    public Page<Booking> getRentalHistoryIdAccount(Pageable pageable, int idAccount, String houseName , LocalDateTime startTime, LocalDateTime endTime, String status) {
        return bookingRepo.getHistoryRentalByIdAccount(pageable , idAccount , houseName , startTime , endTime , status);
    }

    @Override
    public Booking findById(int id) {
        return bookingRepo.findById(id);
    }
}