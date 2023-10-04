package com.booking_house_be.controller;

import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/houses")
public class HouseController {
    @Autowired
    private IHouseService houseService;
    @GetMapping("/{houseId}")
    public ResponseEntity<?> getById(@PathVariable int houseId){
        try{
            return ResponseEntity.ok(houseService.findById(houseId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }
}
