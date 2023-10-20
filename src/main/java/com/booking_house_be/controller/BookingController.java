package com.booking_house_be.controller;

import com.booking_house_be.dto.BookingDto;
import com.booking_house_be.dto.SearchRequest;
import com.booking_house_be.entity.Booking;
import com.booking_house_be.entity.House;
import com.booking_house_be.entity.Review;
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
            houseService.saveHouse(house);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Lịch đặt thuê không ở trạng thái chờ nhận phòng");
        }
    }

    @PostMapping("/wait/{id}")
    public ResponseEntity<?> waitOwnerConfirmBooking(@PathVariable int id) {
        try {
            Booking booking = bookingService.waitOwnerConfirmBooking(id);
            if (booking != null) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().body("Lịch đặt thuê không ở trạng thái chờ nhận phòng");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
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
            houseService.saveHouse(house);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().body("Lịch đặt thuê không ở trạng thái đang ở");
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
        booking.setCreate_at(LocalDateTime.now());
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
        String sortBy = "create_at";
        Sort sort = Sort.by(Sort.Order.desc(sortBy));
        pageable = PageRequest.of(page, size, sort);
        return bookingService.findByHouseAndStartTimeAndEndTimeAndStatus(ownerId, nameSearch, status, selectedDateStart, selectedDateEnd, pageable);
    }


    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(bookingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getByIdAccount/{idAccount}")
    public ResponseEntity<?> getByIdAccount(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "5") int size,
                                            @PathVariable int idAccount) {
        Pageable pageable;
        String sortBy = "create_at";
        Sort sort = Sort.by(Sort.Order.desc(sortBy));
        pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(bookingService.getByIdAccount(pageable, idAccount), HttpStatus.OK);
    }

    @PostMapping("/getByIdAccount/{idAccount}")
    public ResponseEntity<?> getHistoryRentalAccount(@RequestParam(value = "page", defaultValue = "0") int page,
                                                     @RequestParam(value = "size", defaultValue = "5") int size,
                                                     @PathVariable int idAccount
            , @RequestBody BookingDto bookingDto) {
        Pageable pageable;
        String sortBy = "create_at";
        Sort sort = Sort.by(Sort.Order.desc(sortBy));
        pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(bookingService.getRentalHistoryIdAccount(pageable
                , idAccount
                , bookingDto.getHouseName()
                , bookingDto.getStartTime()
                , bookingDto.getEndTime()
                , bookingDto.getStatus()), HttpStatus.OK);
    }

    @PostMapping("/cancel-booking/{id}")
    public ResponseEntity<?> cancelBookingUser(@PathVariable int id, @RequestBody Map<String, String> requestBody) {
        try {
            String message = requestBody.get("message");
            Booking booking = bookingService.findById(id);
            String toEmail = booking.getHouse().getOwner().getEmail();
            String contentTitle = "Khách hàng đã hủy lịch thuê nhà";
            bookingService.cancelBooking(booking, toEmail, contentTitle, message);
            return ResponseEntity.ok("Hủy thành công");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }

    @PostMapping("/reviews")
    public ResponseEntity<?> createReview(@RequestBody Review review) {
        try {
            return ResponseEntity.ok(bookingService.createReview(review));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }
    @GetMapping("/getSpending/{idAccount}")
   public ResponseEntity<?> getSpendingAccount(@PathVariable int idAccount) {
        return ResponseEntity.ok(bookingService.getSpendingUser(idAccount));
   }
}
