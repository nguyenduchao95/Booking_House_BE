package com.booking_house_be.controller;

import com.booking_house_be.entity.Booking;
import com.booking_house_be.entity.House;
import com.booking_house_be.service.IBookingService;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    IBookingService bookingService;
    @Autowired
    IHouseService houseService;
    @GetMapping("/list")
    public ResponseEntity<List<Booking>> listBooking(){
        return new ResponseEntity<>(bookingService.getAllBooking(), HttpStatus.OK);
    }
    @PostMapping("/checkin/{id}")
    public ResponseEntity<?> checkin(@PathVariable int id) {
        Optional<Booking> optionalBooking = bookingService.getBookingById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            House house = houseService.findById(booking.getHouse().getId());
            if (booking.getStatus().equals("Chờ nhận phòng")) {
                booking.setStatus("Đang ở");
                bookingService.save(booking);
                house.setStatus("Đang cho thuê");
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().body("Lịch đặt thuê không ở trạng thái chờ nhận phòng");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<?> checkout(@PathVariable int id) {
        Optional<Booking> optionalBooking = bookingService.getBookingById(id);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            House house = houseService.findById(booking.getHouse().getId());
            if (booking.getStatus().equals("Đang ở")) {
                booking.setStatus("Đã trả phòng");
                house.setStatus("Đang trống");
                bookingService.save(booking);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().body("Lịch đặt thuê không ở trạng thái đang ở");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
