package com.booking_house_be.controller;
import com.booking_house_be.entity.House;
import com.booking_house_be.repository.IHouseRepo;
import com.booking_house_be.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/houses")
public class HouseController {
    @Autowired
    private IHouseService houseService;

    @GetMapping("/{houseId}")
    public ResponseEntity<?> getById(@PathVariable int houseId) {
        try {
            return ResponseEntity.ok(houseService.findById(houseId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).build();
        }
    }


    @GetMapping("/owner/{ownerId}")
    public Page<IHouseRepo.HouseInfo> getHousesByOwnerId(@PathVariable int ownerId,
                                                         @RequestParam(value = "page", defaultValue = "0") int page,
                                                         @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return houseService.getHousesByOwnerId(ownerId, pageable);
    }

    @GetMapping("/owner/by-name/{ownerId}")
    public Page<House> findByOwnerIdAndNameContains(@PathVariable int ownerId,
                                                    @RequestParam("name") String name,
                                                    @RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return houseService.findByOwnerIdAndNameContains(ownerId, name, pageable);
    }

}