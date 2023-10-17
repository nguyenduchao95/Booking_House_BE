package com.booking_house_be.controller;

import com.booking_house_be.dto.HouseDto;
import com.booking_house_be.entity.Booking;
import com.booking_house_be.entity.House;
import com.booking_house_be.entity.Owner;
import com.booking_house_be.repository.IOwnerRepo;
import com.booking_house_be.service.IBookingService;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private IHouseService houseService;
    @Autowired
    private IOwnerRepo ownerRepo;
    @Autowired
    IBookingService bookingService;

    @PostMapping("/create-house")
    public ResponseEntity<?> createHouse(@RequestBody HouseDto houseDto) {
        try {
            House house = houseService.createHouse(houseDto);
            if (house == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Create house fail!");
            else
                return ResponseEntity.ok(house);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }

    @PostMapping("/edit-house")
    public ResponseEntity<?> editHouse(@RequestBody HouseDto houseDto) {
        try {
            House house = houseService.editHouse(houseDto);
            if (house == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Edit house fail!");
            else
                return ResponseEntity.ok(house);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }

    @PostMapping("/cancel-booking/{id}")
    public ResponseEntity<?> cancelBookingOwner(@PathVariable int id, @RequestBody Map<String, String> requestBody) {
        try {
            String message = requestBody.get("message");
            Booking booking = bookingService.findById(id);
            String toEmail = booking.getAccount().getEmail();
            String contentTitle = "Chủ nhà đã hủy lịch thuê nhà";
            bookingService.cancelBooking(booking, toEmail, contentTitle, message);
            return ResponseEntity.ok("Hủy thành công");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }
    @GetMapping("/getOwnerDto")
    public ResponseEntity<?> a(@RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "size", defaultValue = "7") int size
    ,@RequestParam(value = "nameSearch" , defaultValue = "")  String nameSearch) {
        String sortBy = "id";
        Sort sort = Sort.by(Sort.Order.asc(sortBy));
        Pageable pageable  = PageRequest.of(page ,size , sort);
        return  ResponseEntity.ok(ownerRepo.getOwnerDto(pageable , nameSearch));
    }

}
