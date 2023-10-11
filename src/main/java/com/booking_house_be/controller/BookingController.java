package com.booking_house_be.controller;
import com.booking_house_be.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @GetMapping("/{ownerId}")
    private List<Double> getMonthlyRevenuesByOwnerAndYear(
            @PathVariable int ownerId,
            @Param(value = "year") int year) {
        return bookingService.getDailyRevenueByOwnerAndMonth(ownerId, year);
    }

    @GetMapping("/{ownerId}/week")
    private List<Double> getDailyRevenueByOwnerAndWeek(
            @PathVariable int ownerId,
            @Param(value = "month") int month,
            @Param(value = "year") int year,
            @Param(value = "startDay") int startDay,
            @Param(value = "endDay") int endDay) {
        return bookingService.getDailyRevenueByOwnerAndWeek(ownerId, month, year, startDay, endDay);
    }
}
