package com.booking_house_be.service.impl;

import com.booking_house_be.repository.IBookingRepo;
import com.booking_house_be.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Autowired
    IBookingRepo bookingRepo;

    @Override
    public List<Double> getDailyRevenueByOwnerAndMonth(int ownerId, int year) {
        return this.getMonthlyRevenuesByOwnerAndYear(ownerId,year);
    }
    List<Double> getMonthlyRevenuesByOwnerAndYear(int ownerId, int year) {
        List<Object[]> result = bookingRepo.getMonthlyRevenueByOwnerAndYear(ownerId, year);
        List<Double> monthlyRevenues = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {
            boolean found = false;

            for (Object[] row : result) {
                int rowMonth = (int) row[0];
                double revenue = (double) row[1];

                if (rowMonth == month) {
                    monthlyRevenues.add(revenue);
                    found = true;
                    break;
                }
            }

            if (!found) {
                monthlyRevenues.add(0.0);
            }
        }
        return monthlyRevenues;
    }



    @Override
    public List<Double> getDailyRevenueByOwnerAndWeek(int ownerId,int month,int year, int startDay,int endDay) {
        return this.getDailyRevenuesByOwnerAndWeek( ownerId, month, year,  startDay, endDay);
    }

    List<Double> getDailyRevenuesByOwnerAndMonth(int ownerId, int year, int month) {
        List<Object[]> result =bookingRepo.getDailyRevenueByOwnerAndMonth(ownerId, year, month);
        List<Double> dailyRevenues = new ArrayList<>();
        for (int day = 1; day <= 31; day++) {
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


}