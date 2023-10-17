package com.booking_house_be.controller;

import com.booking_house_be.dto.BookingDto;
import com.booking_house_be.dto.SearchRequest;
import com.booking_house_be.entity.Booking;
import com.booking_house_be.entity.House;
import com.booking_house_be.service.IBookingService;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    IBookingService bookingService;
    @Autowired
    IHouseService houseService;

    @GetMapping("/list")
    public ResponseEntity<List<Booking>> listBooking() {
        return new ResponseEntity<>(bookingService.getAllBooking(), HttpStatus.OK);
    }

    @PostMapping("/checkin/{id}")
    public ResponseEntity<?> checkin(@PathVariable int id) {
        Booking booking = bookingService.findById(id);
        House house = houseService.findById(booking.getHouse().getId());
        if (booking.getStatus().equals("Chờ nhận phòng")) {
            booking.setStatus("Đang ở");
            bookingService.save(booking);
            house.setStatus("Đang cho thuê");
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Lịch đặt thuê không ở trạng thái chờ nhận phòng");
        }
    }

    @PostMapping("/wait/{id}")
    public ResponseEntity<?> waitOwnerConfirmBooking(@PathVariable int id) {
        Booking booking = bookingService.findById(id);
        if (booking.getStatus().equals("Chờ xác nhận")) {
            booking.setStatus("Chờ nhận phòng");
            bookingService.save(booking);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Lịch đặt thuê không ở trạng thái chờ nhận phòng");
        }
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<?> checkout(@PathVariable int id) {
        Booking booking = bookingService.findById(id);
        House house = houseService.findById(booking.getHouse().getId());
        if (booking.getStatus().equals("Đang ở")) {
            booking.setStatus("Đã trả phòng");
            house.setStatus("Đang trống");
            bookingService.save(booking);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Lịch đặt thuê không ở trạng thái đang ở");
        }
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<?> cancel(@PathVariable int id) {
        Booking booking = bookingService.findById(id);
        House house = houseService.findById(booking.getHouse().getId());
        if (booking.getStatus().equals("Chờ nhận phòng") || booking.getStatus().equals("Chờ xác nhận")) {
            booking.setStatus("Đã hủy");
            booking.setTotal(0);
            house.setStatus("Đang trống");
            bookingService.save(booking);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Không được huỷ");
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteBookingById(@PathVariable int id) {
        bookingService.deleteById(id);
        return ResponseEntity.ok("Đã xoá thành công");
    }

    @GetMapping("/house/{houseId}")
    public ResponseEntity<?> getBookingsByHouseId(@PathVariable int houseId) {
        try {
            return ResponseEntity.ok(bookingService.findAllByHouseIdAndStatus(houseId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> bookHouse(@RequestBody Booking booking) {
        try {
            return ResponseEntity.ok(bookingService.bookingHouse(booking));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
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

    @PostMapping("/{ownerId}/search")
    private Page<Booking> searchBookingsByOwnerId(
            @PathVariable int ownerId,
            @RequestBody SearchRequest requestData,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        String nameSearch = requestData.getNameSearch();
        String status = requestData.getStatus();
        LocalDateTime selectedDateStart = requestData.getSelectedDateStart();
        LocalDateTime selectedDateEnd = requestData.getSelectedDateEnd();
        Pageable pageable;
        String sortBy = "startTime";
        Sort sort = Sort.by(Sort.Order.desc(sortBy));
        pageable = PageRequest.of(page, size, sort);
        return bookingService.findByHouseAndStartTimeAndEndTimeAndStatus(ownerId, nameSearch, status, selectedDateStart, selectedDateEnd, pageable);
    }


    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(bookingService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/getByIdAccount/{idAccount}")
    public ResponseEntity<?> getHistoryRentalAccount(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "7") int size,
                                                     @PathVariable int idAccount
            , @RequestBody BookingDto bookingDto) {
        Pageable pageable;
        String sortBy = "start_time";
        Sort sort = Sort.by(Sort.Order.asc(sortBy));
        pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(bookingService.getRentalHistoryIdAccount(pageable
                , idAccount
                , bookingDto.getHouseName()
                , bookingDto.getStartTime()
                , bookingDto.getEndTime()
                , bookingDto.getStatus()), HttpStatus.OK);
    }

    @GetMapping("/cancelBooking/{idBooking}")
    public ResponseEntity<?> cancelBooking(@PathVariable int idBooking) {
        Booking booking = bookingService.findById(idBooking);
        booking.setStatus("Đã hủy");
        bookingService.save(booking);
        return new ResponseEntity<>("Bạn đã hủy thuê nhà", HttpStatus.OK);
    }
}
