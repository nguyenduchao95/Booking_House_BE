package com.booking_house_be.controller;

import com.booking_house_be.dto.HouseDto;
import com.booking_house_be.entity.House;
import com.booking_house_be.entity.Owner;
import com.booking_house_be.repository.IOwnerRepo;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private IHouseService houseService;

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
}
