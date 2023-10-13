package com.booking_house_be.controller;

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

    @PostMapping("/checkout/{id}")
    public ResponseEntity<?> checkout(@PathVariable int id) {
        Booking booking  = bookingService.findById(id);
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
        Booking booking  = bookingService.findById(id);
        House house = houseService.findById(booking.getHouse().getId());
            if (booking.getStatus().equals("Chờ nhận phòng")) {
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
    public ResponseEntity<?> getBookingsByHouseId(@PathVariable int houseId,
                                                  @RequestParam(name="status", defaultValue = "Chờ nhận phòng") String status) {
        try {
            return ResponseEntity.ok(bookingService.findAllByHouseIdAndStatus(houseId, status));
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

    @GetMapping("/{ownerId}/search")
    private Page<Booking> searchBookingsByOwnerId(@PathVariable int ownerId,
                                                  @RequestParam("nameSearch") String nameSearch,
                                                  @RequestParam("status") String status,
                                                  @RequestParam(value = "yearStart", required = false) int yearStart,
                                                  @RequestParam(value = "monthStart", required = false) int monthStart,
                                                  @RequestParam(value = "dayStart", required = false) int dayStart,
                                                  @RequestParam(value = "yearEnd", required = false) int yearEnd,
                                                  @RequestParam(value = "monthEnd", required = false) int monthEnd,
                                                  @RequestParam(value = "dayEnd", required = false) int dayEnd,
                                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable;
        String sortBy = "startTime";
        Sort sort = Sort.by(Sort.Order.desc(sortBy));
        pageable = PageRequest.of(page, size, sort);
        status = status.replace("_", " ");
        if (nameSearch.equals("")) {
            nameSearch = null;
        }
        if (status.equals("")) {
            status = null;
        }
        if (yearStart == yearEnd && monthStart == monthEnd && dayStart == dayEnd) {
            yearEnd = 0;
        }
        ;
        if (yearStart != 0 && monthStart != 0 && dayStart != 0 && yearEnd != 0 && monthEnd != 0 && dayEnd != 0) {
            return bookingService.findByHouseAndStartTimeAndEndTimeAndStatus(ownerId, nameSearch, status, yearStart, monthStart, dayStart, yearEnd, monthEnd, dayEnd, pageable);
        } else if (yearStart == 0 || monthStart == 0 && dayStart == 0|| yearEnd == 0 || monthEnd == 0 || dayEnd == 0) {
            return bookingService.findByHouseAndStatus(ownerId, nameSearch, status, pageable);
        } else {
            return bookingService.findBookingsByOwnerId(ownerId, pageable);
        }
    }


    @GetMapping("/search/{ownerId}")
    private Page<Booking> findByHouseAndStatus(@PathVariable int ownerId,
                                               @RequestParam("nameSearch") String nameSearch,
                                               @RequestParam("status") String status,
                                               @RequestParam(value = "page", defaultValue = "0") int page,
                                               @RequestParam(value = "size", defaultValue = "5") int size) {
        Pageable pageable;
        String sortBy = "startTime";
        Sort sort = Sort.by(Sort.Order.desc(sortBy));
        pageable = PageRequest.of(page, size, sort);
        return bookingService.findByHouseAndStatus(ownerId, nameSearch, status, pageable);
    }


    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(bookingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getByIdAccount/{idAccount}")
    public ResponseEntity<?> getByIdAccount(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "7") int size,
                                            @PathVariable int idAccount) {
        Pageable pageable;
        String sortBy = "start_time";
        Sort sort = Sort.by(Sort.Order.desc(sortBy));
        pageable = PageRequest.of(page, size, sort);
        return new ResponseEntity<>(bookingService.getByIdAccount(pageable, idAccount), HttpStatus.OK);
    }

    @GetMapping("/cancelBooking/{idBooking}")
    public ResponseEntity<?> cancelBooking(@PathVariable int idBooking) {
        Booking booking = bookingService.findById(idBooking);
        booking.setStatus("Đã hủy");
        bookingService.save(booking);
        return new ResponseEntity<>("Bạn đã hủy thuê nhà", HttpStatus.OK);
    }
}
