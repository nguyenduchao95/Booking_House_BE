package com.booking_house_be.controller;

import com.booking_house_be.entity.Booking;
import com.booking_house_be.repository.IBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private IBookingRepo bookingRepo;
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(bookingRepo.findAll() , HttpStatus.OK);
    }
    @GetMapping("/getByIdAccount/{idAccount}")
    public ResponseEntity<?> getByIdAccount(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "7") int size,
                                            @PathVariable int idAccount){
        Pageable pageable = PageRequest.of(page , size);
        return new ResponseEntity<>(bookingRepo.getByIdAccount( pageable , idAccount) , HttpStatus.OK);
    }
    @GetMapping("/cancelBooking/{idBooking}")
    public ResponseEntity<?> cancelBooking(@PathVariable int idBooking){
        Booking booking = bookingRepo.findById(idBooking);
        booking.setStatus("Đã hủy");
        bookingRepo.save(booking);
        return new ResponseEntity<>("Bạn đã hủy thuê nhà" , HttpStatus.OK);
    }
}
